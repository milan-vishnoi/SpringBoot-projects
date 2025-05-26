package com.miproject.sampleApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.miproject.sampleApp.dto.FeedbackDTO;
import com.miproject.sampleApp.mapper.FeedbackMapper;
import com.miproject.sampleApp.model.Feedback;
import com.miproject.sampleApp.service.FeedbackService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/feedback")
public class FeedbackController {

    public FeedbackService feedbackService;
    @Autowired
    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @GetMapping
    public ResponseEntity<List<FeedbackDTO>> getAllFeedbacks() {
        List<FeedbackDTO> feedbackDTOList = feedbackService.getAllFeedbacks().stream().map(FeedbackMapper::toDTO).toList();
        return ResponseEntity.ok(feedbackDTOList);
    }

    @PostMapping
    public ResponseEntity<FeedbackDTO> saveFeedback(@Valid @RequestBody FeedbackDTO feedback) {
          Feedback savedFeedback = feedbackService.saveFeedback(FeedbackMapper.toEntity(feedback));
          return new ResponseEntity<>(FeedbackMapper.toDTO(savedFeedback),HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FeedbackDTO> getFeedbackById(@PathVariable Long id) {
        return new ResponseEntity<>(FeedbackMapper.toDTO(feedbackService.getFeedbackById(id)),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FeedbackDTO> updateFeedback(@PathVariable Long id, @Valid @RequestBody FeedbackDTO updatedFeedback)
    {
        return ResponseEntity.ok(FeedbackMapper.toDTO(feedbackService.updateFeedback(id,FeedbackMapper.toEntity(updatedFeedback))));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<FeedbackDTO> updatePartialFeedback(@PathVariable Long id, @RequestBody FeedbackDTO partialFeedback)
    {
        return ResponseEntity.ok(FeedbackMapper.toDTO(feedbackService.patchFeedback(id,FeedbackMapper.toEntity(partialFeedback))));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFeedback(@PathVariable Long id) {
        feedbackService.deleteFeedback(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
    
}
