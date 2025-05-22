package com.miproject.sampleApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.miproject.sampleApp.model.Feedback;
import com.miproject.sampleApp.service.FeedbackService;

@RestController
@RequestMapping("/api/feedback")
public class FeedbackController {

    public FeedbackService feedbackService;
    @Autowired
    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @GetMapping
    public ResponseEntity<List<Feedback>> getAllFeedbacks() {
        return ResponseEntity.ok(feedbackService.getAllFeedbacks());
    }

    @PostMapping
    public ResponseEntity<Feedback> saveFeedback(@RequestBody Feedback feedback) {
          return new ResponseEntity<>(feedbackService.saveFeedback(feedback),HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Feedback> getFeedbackById(@PathVariable Long id) {
        return new ResponseEntity<>(feedbackService.getFeedbackById(id),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFeedback(@PathVariable Long id) {
        feedbackService.deleteFeedback(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
    
}
