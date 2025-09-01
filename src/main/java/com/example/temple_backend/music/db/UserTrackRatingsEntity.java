package com.example.temple_backend.music.db;

import com.example.temple_backend.user.db.UsersEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "user_track_ratings")
public class UserTrackRatingsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rating_id")
    private Long ratingId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id",
      foreignKey = @ForeignKey(name = "fk_user_track_ratings_user"))
    private UsersEntity user;

    @Column(name = "track_id", nullable = false, length = 50)
    private String trackId;

    @Column(name = "rating")
    private Integer rating; // 1~5점 평점, null 가능

    @Column(name = "rated_at")
    @CreationTimestamp
    private LocalDateTime ratedAt;
}
