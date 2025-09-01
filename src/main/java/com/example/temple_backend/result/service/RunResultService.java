package com.example.temple_backend.result.service;

import com.example.temple_backend.result.db.RunResultsEntity;
import com.example.temple_backend.result.db.RunResultsRepository;
import com.example.temple_backend.result.model.RunResultRequest;
import com.example.temple_backend.result.model.RunResultResponse;
import com.example.temple_backend.running.db.RunningRepository;
import com.example.temple_backend.running.db.RunsEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class RunResultService {
    private final RunResultsRepository runResultsRepository;
    private final RunningRepository runningRepository;
    private final RunResultConverter runResultConverter;

    /**
      * 러닝 결과를 저장합니다.
     * @param runId 러닝 세션 ID
     * @param runResultRequest 러닝 결과 데이터
     * @return 저장된 러닝 결과 DTO
    */
    @Transactional
    public RunResultResponse saveResult(Long runId, RunResultRequest runResultRequest) {
        // 1. RunsEntity 존재 확인
        RunsEntity runsEntity = runningRepository.findById(runId)
          .orElseThrow(() -> new RuntimeException("해당 러닝을 찾을 수 없습니다. ID: " + runId));

        // 2. 이미 결과가 저장되어 있는지 확인
        if (runResultsRepository.findByRun_RunId(runId).isPresent()) {
            throw new RuntimeException("해당 러닝의 결과가 이미 저장되어 있습니다. runId: " + runId);
        }

        // 3. Entity 생성 및 저장
        var entity = RunResultsEntity.builder()
          .run(runsEntity)
          .duration(runResultRequest.getDuration())
          .distance(runResultRequest.getDistance())
          .calories(runResultRequest.getCalories())
          .avgCadence(runResultRequest.getAvgCadence())
          .maxCadence(runResultRequest.getMaxCadence())
          .minCadence(runResultRequest.getMinCadence())
          .abnormalCount(runResultRequest.getAbnormalCount())
          .musicCount(runResultRequest.getMusicCount())
          .cadenceAccuracy(runResultRequest.getCadenceAccuracy())
          .breathNormalAcc(runResultRequest.getBreathNormalAcc())
          .breathAbnormalAcc(runResultRequest.getBreathAbnormalAcc())
          .musicBpmList(runResultRequest.getMusicBpmList())
          .feedbackSummary(runResultRequest.getFeedbackSummary())
          .cadenceHistory(runResultRequest.getCadenceHistory())
          .build();

        var saveEntity = runResultsRepository.save(entity);
        log.info("러닝 결과가 저장되었습니다. resultId: {}, runId: {}", saveEntity.getResultId(), runId);

        return runResultConverter.toDto(saveEntity);
    }

    /**
     * 러닝 결과를 조회합니다.
     * @param runId 러닝 세션 ID
     * @return 러닝 결과 DTO
     */
    @Transactional(readOnly = true)
    public RunResultResponse getResult(Long runId) {
        RunResultsEntity runResultsEntity = runResultsRepository.findByRun_RunId(runId)
          .orElseThrow(() -> new RuntimeException("해당 러닝의 결과를 찾을 수 없습니다. runId: " + runId));

        return runResultConverter.toDto(runResultsEntity);
    }
}
