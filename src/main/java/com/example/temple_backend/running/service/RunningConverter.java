package com.example.temple_backend.running.service;

import com.example.temple_backend.running.db.RunsEntity;
import com.example.temple_backend.running.model.RunningDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Component
public class RunningConverter {
    public RunningDto toDto(RunsEntity runsEntity) {
        return RunningDto.builder()
          .id(runsEntity.getRunId())
          .userId(runsEntity.getUser() != null ? runsEntity.getUser().getUserId() : null)
          .mode(runsEntity.getMode())
          .targetDuration(runsEntity.getTargetDuration())
          .breathPattern(runsEntity.getBreathPattern())
          .targetCadence(runsEntity.getTargetCadence())
          .startTime(runsEntity.getStartTime())
          .endTime(runsEntity.getEndTime())
          .build();
    }
}
