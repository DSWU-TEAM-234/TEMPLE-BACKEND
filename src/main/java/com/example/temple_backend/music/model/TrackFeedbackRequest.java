package com.example.temple_backend.music.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TrackFeedbackRequest {
    private String userId;
    private String trackId;
    private Integer rating; // 1~5점 평점 (선택사항)
//    private String action;  // like, dislike, skip 등 (선택사항)
}
