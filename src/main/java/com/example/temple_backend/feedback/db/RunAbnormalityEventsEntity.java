//package com.example.temple_backend.feedback.db;
//
//import com.example.temple_backend.running.db.RunsEntity;
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.FetchType;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
//import java.time.LocalDateTime;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import lombok.ToString;
//import lombok.extern.java.Log;
//import org.springframework.data.annotation.Id;
//
//@Getter
//@Setter
//@Builder
//@ToString
//@NoArgsConstructor
//@AllArgsConstructor
//@Entity(name = "run_abnormality_events")
//public class RunAbnormalityEventsEntity {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long eventId;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "run_id", referencedColumnName = "run_id", insertable = false, updatable = false)
//    private RunsEntity run;
//
//    @Column(name = "start_time", nullable = false)
//    private LocalDateTime startTime;
//
//    @Column(nullable = false)
//    private int duration;
//
//    @Column(name = "feedback_type", length = 20, nullable = false)
//    private String feedbackType;
//
//    @Column(name = "feedback_msg", columnDefinition = "TEXT", nullable = false)
//    private String feedbackMsg;
//
//    @Column(name = "rest_period", nullable = false)
//    private int restPeriod = 60;
//
//}
