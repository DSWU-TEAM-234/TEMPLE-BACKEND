package com.example.temple_backend.result.controller;

import com.example.temple_backend.result.db.RunResultsEntity;
import com.example.temple_backend.result.model.RunResultRequest;
import com.example.temple_backend.result.model.RunResultResponse;
import com.example.temple_backend.result.service.RunResultService;
import com.example.temple_backend.running.db.RunsEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/runs")
public class ResultController {
    private final RunResultService runResultService;

    /**
     * 러닝 종료 후 결과를 저장하는 API
     * @param runId 러닝 세션 ID
     * @param runResultRequest 러닝 결과 데이터
     * @return 저장된 러닝 결과 DTO
     */
    @PostMapping("/{runId}/results")
    public RunResultResponse save(
      @PathVariable Long runId,
      @RequestBody RunResultRequest runResultRequest
    ) {
        return runResultService.saveResult(runId, runResultRequest);
    }

    /**
     * 저장된 러닝 결과를 조회하는 API
     * @param runId 러닝 세션 ID
     * @return 러닝 결과 DTO
     */
    @GetMapping("/{runId}/results")
    public RunResultResponse getResult(@PathVariable Long runId) {
        return runResultService.getResult(runId);
    }
}
