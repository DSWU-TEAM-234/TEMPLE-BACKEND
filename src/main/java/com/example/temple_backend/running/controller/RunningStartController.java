package com.example.temple_backend.running.controller;

import com.example.temple_backend.running.model.RunningDto;
import com.example.temple_backend.running.model.RunningRequest;
import com.example.temple_backend.running.service.RunningService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/runs")
public class RunningStartController {
    private final RunningService runningService;
    /**.
     * 러닝 시작 버튼을 눌렀을 때, 러닝 세션 시작 api
     * @param runningRequest: api 명세서의 리퀘스트
     * */
    @PostMapping("/start")
    public RunningDto start(
        @RequestBody RunningRequest runningRequest
    ) {
        log.info("러닝 시작 요청: userId={}, mode={}", runningRequest.getUserId(), runningRequest.getMode());
        return runningService.start(runningRequest);
    }
}
