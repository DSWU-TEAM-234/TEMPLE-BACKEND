package com.example.temple_backend.music.db;

import java.beans.JavaBean;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserTrackRatingsRepository extends JpaRepository<UserTrackRatingsEntity, Long> {
    // 사용자와 트랙 ID로 기존 평점 찾기
    Optional<UserTrackRatingsEntity> findByUser_UserIdAndTrackId(String userId, String trackId);

    // 사용자의 모든 평점 조회
    List<UserTrackRatingsEntity> findByUser_UserId(String userId);

    // 사용자의 평균 평점 계산
    @Query("SELECT AVG(r.rating) FROM user_track_ratings r WHERE r.user.userId = :userId AND r.rating IS NOT NULL")
    Double findAverageRatingByUserId(@Param("userId") String userId);

    // 특정 트랙의 평균 평점 계산
    @Query("SELECT AVG(r.rating) FROM user_track_ratings r WHERE r.trackId = :trackId AND r.rating IS NOT NULL")
    Double findAverageRatingByTrackId(@Param("trackId") String trackId);

    // 사용자의 평점 개수 조회
    @Query("SELECT COUNT(r) FROM user_track_ratings r WHERE r.user.userId = :userId AND r.rating IS NOT NULL")
    Long countRatingsByUserId(@Param("userId") String userId);
}
