//package com.example.temple_backend.feedback.controller;
//
//import com.example.temple_backend.feedback.db.RunAbnormalityEventsEntity;
//import com.example.temple_backend.feedback.model.AbnormalEventDto;
//import com.example.temple_backend.feedback.service.AbnormalityEventsService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequiredArgsConstructor
//@RequestMapping("/api/runs")
//public class AbnormalityEventsController {
//
//    @PostMapping("/{runId}/abnormality-events")
//    public AbnormalEventDto generate(
//      @PathVariable Long runId,
//      @RequestBody AbnormalEventDto abnormalEventDto
//    ) {
//        return null;
//    }
//
//}
