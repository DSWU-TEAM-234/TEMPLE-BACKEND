package com.example.temple_backend.music.model;
import lombok.Getter;
import lombok.Setter;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TrackFeedbackResponse {
    private String message;
    private Double currentScore; // 사용자의 현재 평균 평점
}
