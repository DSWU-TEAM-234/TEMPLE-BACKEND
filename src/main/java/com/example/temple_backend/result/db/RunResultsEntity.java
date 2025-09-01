package com.example.temple_backend.result.db;

import com.example.temple_backend.common.JsonAttributeConverters.ListToJsonConverter;
import com.example.temple_backend.common.JsonAttributeConverters.MapToJsonConverter;
import com.example.temple_backend.running.db.RunsEntity;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import jakarta.persistence.Id;
import org.hibernate.annotations.Type;


@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "run_results")
public class RunResultsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long resultId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "run_id", nullable = false,
      foreignKey = @ForeignKey(name = "fk_run_results_run"))
    private RunsEntity run;

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

    @Convert(converter = ListToJsonConverter.class)
    @Column(columnDefinition = "json")
    private List<Integer> musicBpmList;

    @Convert(converter = MapToJsonConverter.class)
    @Column(columnDefinition = "json")
    private Map<String, Integer> feedbackSummary;

    @Convert(converter = ListToJsonConverter.class)
    @Column(columnDefinition = "json")
    private List<Integer> cadenceHistory;

}
