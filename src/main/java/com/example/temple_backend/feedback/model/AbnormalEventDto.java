//package com.example.temple_backend.feedback.model;
//
//import com.example.temple_backend.running.db.RunsEntity;
//import com.fasterxml.jackson.databind.PropertyNamingStrategies;
//import com.fasterxml.jackson.databind.annotation.JsonNaming;
//import jakarta.persistence.Column;
//import jakarta.persistence.FetchType;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
//import java.time.LocalDateTime;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import lombok.ToString;
//
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
//@ToString
//@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
//public class AbnormalEventDto {
//    private Long eventId;
//
//    private Long runId;
//
//    private LocalDateTime startTime;
//
//    private int duration;
//
//    private String feedbackType;
//
//    private String feedbackMsg;
//}
