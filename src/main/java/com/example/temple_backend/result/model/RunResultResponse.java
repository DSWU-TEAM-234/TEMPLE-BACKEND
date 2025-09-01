package com.example.temple_backend.result.model;

import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RunResultResponse {
    private Long resultId;
    private Long runId;
    private int duration;
    private float distance;
    private int calories;
    private float avgCadence;
    private int maxCadence;
    private int minCadence;
    private int abnormalCount;
    private int musicCount;
    private float cadenceAccuracy;
    private int breathNormalAcc;
    private int breathAbnormalAcc;
    private List<Integer> musicBpmList;
    private Map<String, Integer> feedbackSummary;
    private List<Integer> cadenceHistory;

}
