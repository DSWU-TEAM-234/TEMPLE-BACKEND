package com.example.temple_backend.music.controller;
import com.example.temple_backend.music.model.TrackFeedbackDto;
import com.example.temple_backend.music.model.TrackFeedbackRequest;
import com.example.temple_backend.music.model.TrackFeedbackResponse;
import com.example.temple_backend.music.service.TrackFeedbackService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/runs")
public class TrackFeedbackController {
    private final TrackFeedbackService trackFeedbackService;

    /**
     * 러닝 중 트랙에 대한 피드백을 저장
     * @param runId 러닝 세션 ID
     * @param trackFeedbackRequest 피드백 요청 데이터
     * @return 피드백 응답 데이터
     */
    @PostMapping("/{runId}/feedback")
    public TrackFeedbackResponse saveFeedback(
      @PathVariable Long runId,
      @RequestBody TrackFeedbackRequest trackFeedbackRequest
    ) {
        log.info("트랙 피드백 저장 요청: runId={}, userId={}, trackId={}",
          runId, trackFeedbackRequest.getUserId(), trackFeedbackRequest.getTrackId());

        return trackFeedbackService.saveFeedback(runId, trackFeedbackRequest);
    }

    /**
     * 사용자의 특정 트랙에 대한 피드백을 조회하는 API
     * @param userId 사용자 ID
     * @param trackId 트랙 ID
     * @return 피드백 정보
     */
    @GetMapping("/feedback")
    public TrackFeedbackDto getFeedback(
      @RequestParam String userId,
      @RequestParam String trackId
    ) {
        return trackFeedbackService.getFeedbackByUserAndTrack(userId, trackId);
    }
}
