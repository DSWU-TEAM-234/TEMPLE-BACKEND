package com.example.temple_backend.user.service;

import com.example.temple_backend.user.db.UsersEntity;
import com.example.temple_backend.user.model.UserDto;
import org.springframework.stereotype.Component;

@Component
public class AuthConverter {
    public UserDto toDto(UsersEntity entity) {
        return UserDto.builder()
          .userId(entity.getUserId())
          .spotifyUserId(entity.getSpotifyUserId())
          .displayName(entity.getDisplayName())
          .email(entity.getEmail())
          .profileImageUrl(entity.getProfileImageUrl())
          .createdAt(entity.getCreatedAt())
          .height(entity.getHeight())
          .weight(entity.getWeight())
          .build();
    }
}
