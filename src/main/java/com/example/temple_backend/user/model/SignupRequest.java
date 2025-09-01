package com.example.temple_backend.user.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SignupRequest {
    private String spotifyUserId;
    private String spotifyAccessToken;
    private String spotifyRefreshToken;
    private String displayName;
    private String email;
    private String profileImageUrl;
    private Float height;
    private Float weight;
}
