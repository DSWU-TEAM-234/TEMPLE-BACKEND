package com.example.temple_backend.user.db;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<UsersEntity, String> {
    // 이메일로 사용자 찾기
    Optional<UsersEntity> findByEmail(String email);

    // Spotify 사용자 ID로 찾기
    Optional<UsersEntity> findBySpotifyUserId(String spotifyUserId);

    // 이메일 중복 확인
    boolean existsByEmail(String email);

    // Spotify 사용자 ID 중복 확인
    boolean existsBySpotifyUserId(String spotifyUserId);
}
