package com.example.temple_backend.running.model;

import com.fasterxml.jackson.annotation.JsonProperty;
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
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class RunningRequest {
    @JsonProperty("userId")
    private String userId; // 추가된 필드

    private String mode;

    @JsonProperty("targetCadence")
    private Integer targetCadence;

    @JsonProperty("targetDuration")
    private Integer targetDuration;

    @JsonProperty("breathPattern")
    private String breathPattern;
}
