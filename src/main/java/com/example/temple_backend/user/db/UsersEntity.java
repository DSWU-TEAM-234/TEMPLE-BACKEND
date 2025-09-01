package com.example.temple_backend.user.db;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import jakarta.persistence.Id;


@Entity(name = "users")
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UsersEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "user_id", length = 36)
    private String userId;

    @Column(name = "spotify_user_id", length = 50)
    private String spotifyUserId;

    @Column(name = "spotify_access_token", columnDefinition = "TEXT")
    private String spotifyAccessToken;

    @Column(name = "spotify_refresh_token", columnDefinition = "TEXT")
    private String spotifyRefreshToken;

    @Column(name = "display_name", length = 100)
    private String displayName;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "profile_image_url", columnDefinition = "TEXT")
    private String profileImageUrl;

    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "height")
    private Float height;

    @Column(name = "weight")
    private Float weight;
}
