package com.example.temple_backend.result.service;

import com.example.temple_backend.result.db.RunResultsEntity;
import com.example.temple_backend.result.model.RunResultResponse;
import org.springframework.stereotype.Component;

@Component
public class RunResultConverter {
    public RunResultResponse toDto(RunResultsEntity entity) {
        return RunResultResponse.builder()
          .resultId(entity.getResultId())
          .runId(entity.getRun().getRunId())
          .duration(entity.getDuration())
          .distance(entity.getDistance())
          .calories(entity.getCalories())
          .avgCadence(entity.getAvgCadence())
          .maxCadence(entity.getMaxCadence())
          .minCadence(entity.getMinCadence())
          .abnormalCount(entity.getAbnormalCount())
          .musicCount(entity.getMusicCount())
          .cadenceAccuracy(entity.getCadenceAccuracy())
          .breathNormalAcc(entity.getBreathNormalAcc())
          .breathAbnormalAcc(entity.getBreathAbnormalAcc())
          .musicBpmList(entity.getMusicBpmList())
          .feedbackSummary(entity.getFeedbackSummary())
          .cadenceHistory(entity.getCadenceHistory())
          .build();
    }

}
