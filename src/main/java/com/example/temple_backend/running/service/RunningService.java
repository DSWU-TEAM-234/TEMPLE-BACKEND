package com.example.temple_backend.running.service;

import com.example.temple_backend.running.db.RunningRepository;
import com.example.temple_backend.running.db.RunsEntity;
import com.example.temple_backend.running.model.RunningDto;
import com.example.temple_backend.running.model.RunningRequest;
import com.example.temple_backend.user.db.UsersEntity;
import com.example.temple_backend.user.db.UsersRepository;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Service
@RequiredArgsConstructor
public class RunningService {
    private final RunningRepository runningRepository;
    private final UsersRepository usersRepository;
    private final RunningConverter runningConverter;

    /**
     * TODO: 러닝 세션 시작하고 음악을 들려줘야하는데.. 그 부분은 후에 작성!
     *     선택한 BPM에 맞게 노래를 틀어주는 로직을 백엔드에서 작성할지,
     *     혹은 프론트엔드에 작성되어있는지 확인하기
     * */
    @Transactional
    public RunningDto start(
      RunningRequest runningRequest
    ) {
        // 1. 사용자 존재 확인
        UsersEntity user = usersRepository.findById(runningRequest.getUserId())
          .orElseThrow(() -> new RuntimeException("사용자를 찾을 수 없습니다. userId: " + runningRequest.getUserId()));

        // 2. 러닝 엔티티 생성
        var entity = RunsEntity.builder()
          .user(user)
          .mode(runningRequest.getMode())
          .breathPattern(runningRequest.getBreathPattern())
          .targetDuration(runningRequest.getTargetDuration())
          .targetCadence(runningRequest.getTargetCadence())
          .startTime(LocalDateTime.now())
          .build();

        var saveEntity = runningRepository.save(entity);
        log.info("러닝 세션 시작 -> runId: {}, userId: {}", saveEntity.getRunId(), user.getUserId());
        return runningConverter.toDto(saveEntity);
    }
}
