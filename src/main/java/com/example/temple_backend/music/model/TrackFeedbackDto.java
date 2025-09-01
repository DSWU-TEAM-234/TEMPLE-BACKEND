package com.example.temple_backend.music.model;
import lombok.Getter;
import lombok.Setter;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TrackFeedbackDto {
    private Long ratingId;
    private String userId;
    private String trackId;
    private Integer rating;
//    private String action;
    private LocalDateTime ratedAt;
}
