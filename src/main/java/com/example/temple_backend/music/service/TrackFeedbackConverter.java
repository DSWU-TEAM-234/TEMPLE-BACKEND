package com.example.temple_backend.music.service;

import com.example.temple_backend.music.db.UserTrackRatingsEntity;
import com.example.temple_backend.music.model.TrackFeedbackDto;
import org.springframework.stereotype.Component;

@Component
public class TrackFeedbackConverter {
    public TrackFeedbackDto toDto(UserTrackRatingsEntity entity) {
        return TrackFeedbackDto.builder()
          .ratingId(entity.getRatingId())
          .userId(String.valueOf(entity.getUser().getUserId()))
          .trackId(entity.getTrackId())
          .rating(entity.getRating())
          .ratedAt(entity.getRatedAt())
          .build();
    }
}
