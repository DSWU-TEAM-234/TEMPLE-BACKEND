package com.example.temple_backend.music.service;

import com.example.temple_backend.music.db.UserTrackRatingsEntity;
import com.example.temple_backend.music.db.UserTrackRatingsRepository;
import com.example.temple_backend.music.model.TrackFeedbackDto;
import com.example.temple_backend.music.model.TrackFeedbackRequest;
import com.example.temple_backend.music.model.TrackFeedbackResponse;
import com.example.temple_backend.user.db.UsersEntity;
import com.example.temple_backend.user.db.UsersRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class TrackFeedbackService {
    private final UserTrackRatingsRepository userTrackRatingsRepository;
    private final UsersRepository usersRepository;
    private final TrackFeedbackConverter trackFeedbackConverter;

    /**
     * 트랙에 대한 사용자 피드백을 저장
     * @param runId 러닝 세션 ID
     * @param trackFeedbackRequest 피드백 요청 데이터
     * @return 피드백 응답 데이터
     */
    @Transactional
    public TrackFeedbackResponse saveFeedback(Long runId, TrackFeedbackRequest trackFeedbackRequest) {
        // 1. 입력 데이터 검증
        validateFeedbackRequest(trackFeedbackRequest);

        // 2. 사용자 존재 확인
        UsersEntity user = usersRepository.findById(trackFeedbackRequest.getUserId())
          .orElseThrow(() -> new RuntimeException("사용자를 찾을 수 없습니다. userId: " + trackFeedbackRequest.getUserId()));

        // 3. 기존 피드백이 있는지 확인
        var existingRating = userTrackRatingsRepository.findByUser_UserIdAndTrackId(
          trackFeedbackRequest.getUserId(), trackFeedbackRequest.getTrackId());

        UserTrackRatingsEntity entity;

        if (existingRating.isPresent()) {
            // 기존 피드백 업데이트
            entity = existingRating.get();
            if (trackFeedbackRequest.getRating() != null) {
                entity.setRating(trackFeedbackRequest.getRating());
            }

            log.info("기존 피드백 업뎃: ratingId: {}, runId: {}", entity.getRatingId(), runId);
        } else {
            // 새로운 피드백 생성
            entity = UserTrackRatingsEntity.builder()
              .user(user)
              .trackId(trackFeedbackRequest.getTrackId())
              .rating(trackFeedbackRequest.getRating())
//              .action(trackFeedbackRequest.getAction())
              .build();
            log.info("새로운 피드백을 저장했습니다. userId: {}, trackId: {}, runId: {}",
              trackFeedbackRequest.getUserId(), trackFeedbackRequest.getTrackId(), runId);
        }

        // 4. 데이터베이스에 저장
        var saveEntity = userTrackRatingsRepository.save(entity);

        // 5. 사용자의 현재 평균 평점 계산
        Double currentScore = userTrackRatingsRepository.findAverageRatingByUserId(trackFeedbackRequest.getUserId());

        // 6. 응답 생성
        return TrackFeedbackResponse.builder()
          .message("피드백이 저장되었습니다.")
          .currentScore(currentScore != null ? Math.round(currentScore * 10.0) / 10.0 : null) // 소수점 첫째자리까지
          .build();
    }

    /**
     * 사용자의 피드백 내역을 조회
     * @param userId 사용자 ID
     * @return 피드백 목록
     */
    @Transactional(readOnly = true)
    public TrackFeedbackDto getFeedbackByUserAndTrack(String userId, String trackId) {
        UserTrackRatingsEntity entity = userTrackRatingsRepository.findByUser_UserIdAndTrackId(userId, trackId)
          .orElseThrow(() -> new RuntimeException("피드백을 찾을 수 없음 -> userId: " + userId + ", trackId: " + trackId));

        return trackFeedbackConverter.toDto(entity);
    }

    /**
     * 피드백 요청 데이터의 유효성을 검사
     */
    private void validateFeedbackRequest(TrackFeedbackRequest request) {
        if (request.getUserId() == null || request.getUserId().trim().isEmpty()) {
            throw new RuntimeException("사용자 ID 필수");
        }

        if (request.getTrackId() == null || request.getTrackId().trim().isEmpty()) {
            throw new RuntimeException("트랙 ID 필수");
        }

        // rating 범위 검증 (1~5)
        if (request.getRating() != null && (request.getRating() < 1 || request.getRating() > 5)) {
            throw new RuntimeException("평점 1~5 사이의 값이어야함.");
        }
    }

}
