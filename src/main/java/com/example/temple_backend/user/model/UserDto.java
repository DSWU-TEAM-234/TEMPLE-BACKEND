package com.example.temple_backend.user.model;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private String userId;
    private String spotifyUserId;
    private String displayName;
    private String email;
    private String profileImageUrl;
    private LocalDateTime createdAt;
    private Float height;
    private Float weight;
}
