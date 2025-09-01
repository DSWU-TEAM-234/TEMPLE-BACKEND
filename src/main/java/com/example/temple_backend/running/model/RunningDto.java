package com.example.temple_backend.running.model;

import com.example.temple_backend.running.db.RunsEntity;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class RunningDto {
    private Long id;
    private String userId; // 추가된 필드
    private String mode;
    private Integer targetCadence;
    private Integer targetDuration;
    private String breathPattern;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

//    public RunningDto toEntity(RunningDto runningDto) {
//
//    }
}
