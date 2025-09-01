package com.example.temple_backend.user.service;

import com.example.temple_backend.user.db.UsersEntity;
import com.example.temple_backend.user.db.UsersRepository;
import com.example.temple_backend.user.model.SignupRequest;
import com.example.temple_backend.user.model.UserDto;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthService {
    private final UsersRepository usersRepository;
    private final AuthConverter authConverter;

    /**
     * 회원가입을 처리합니다.
     * @param signupRequest 회원가입 요청 데이터
     * @return 생성된 사용자 정보 DTO
     */
    @Transactional
    public UserDto signup(SignupRequest signupRequest) {
        // 1. 이메일 중복 확인
        if (usersRepository.existsByEmail(signupRequest.getEmail())) {
            throw new RuntimeException("이미 사용 중인 이메일입니다: " + signupRequest.getEmail());
        }

        // 2. Spotify 사용자 ID 중복 확인
        if (usersRepository.existsBySpotifyUserId(signupRequest.getSpotifyUserId())) {
            throw new RuntimeException("이미 등록된 Spotify 계정입니다: " + signupRequest.getSpotifyUserId());
        }

        // 3. 사용자 엔티티 생성
        var entity = UsersEntity.builder()
          .spotifyUserId(signupRequest.getSpotifyUserId())
          .spotifyAccessToken(signupRequest.getSpotifyAccessToken())
          .spotifyRefreshToken(signupRequest.getSpotifyRefreshToken())
          .displayName(signupRequest.getDisplayName())
          .email(signupRequest.getEmail())
          .profileImageUrl(signupRequest.getProfileImageUrl())
          .height(signupRequest.getHeight())
          .weight(signupRequest.getWeight())
          .build();

        // 4. 데이터베이스에 저장
        var saveEntity = usersRepository.save(entity);
        log.info("새로운 사용자가 회원가입했습니다. userId: {}, email: {}",
          saveEntity.getUserId(), saveEntity.getEmail());

        // 5. DTO로 변환하여 반환
        return authConverter.toDto(saveEntity);
    }

    /**
     * 사용자 ID로 사용자 정보를 조회합니다.
     * @param userId 사용자 ID
     * @return 사용자 정보 DTO
     */
    @Transactional(readOnly = true)
    public UserDto getUserById(String userId) {
        UsersEntity user = usersRepository.findById(userId)
          .orElseThrow(() -> new RuntimeException("사용자를 찾을 수 없습니다. userId: " + userId));

        return authConverter.toDto(user);
    }

    /**
     * 이메일로 사용자 정보를 조회합니다.
     * @param email 이메일
     * @return 사용자 정보 DTO
     */
    @Transactional(readOnly = true)
    public UserDto getUserByEmail(String email) {
        UsersEntity user = usersRepository.findByEmail(email)
          .orElseThrow(() -> new RuntimeException("사용자를 찾을 수 없습니다. email: " + email));

        return authConverter.toDto(user);
    }

}
