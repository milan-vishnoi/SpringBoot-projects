package com.miproject.sampleApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.miproject.sampleApp.repository.FeedbackRepository;
import com.miproject.sampleApp.exception.FeedbackNotFoundException;
import com.miproject.sampleApp.model.Feedback;
import java.util.List;

@Service
public class FeedbackServiceImpl implements FeedbackService {

    private final FeedbackRepository feedbackRepository;

    @Autowired
    public FeedbackServiceImpl(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    @Override
    public Feedback saveFeedback(Feedback feedback) {
        return feedbackRepository.save(feedback);
    }

    @Override
    public List<Feedback> getAllFeedbacks() {
        return feedbackRepository.findAll();
    }

    @Override
    public Feedback getFeedbackById(Long feedbackId) {
        return feedbackRepository.findById(feedbackId).orElseThrow(()-> new FeedbackNotFoundException(feedbackId));
    }

    @Override
    public Feedback updateFeedback(Long feedbackId, Feedback updatedFeedback) {
        Feedback existingFeedback = feedbackRepository.findById(feedbackId).orElseThrow(()-> new FeedbackNotFoundException(feedbackId));

        existingFeedback.setFeedbackText(updatedFeedback.getFeedbackText());
        existingFeedback.setRating(updatedFeedback.getRating());

        return feedbackRepository.save(existingFeedback);
    }

    @Override
    public Feedback patchFeedback(Long feedbackId, Feedback partialFeedback) {
        Feedback existingFeedback = feedbackRepository.findById(feedbackId).orElseThrow(()-> new FeedbackNotFoundException(feedbackId));
        
        if(partialFeedback.getFeedbackText() != null)
        existingFeedback.setFeedbackText(partialFeedback.getFeedbackText());

        if(partialFeedback.getRating() != null)
        existingFeedback.setRating(partialFeedback.getRating());

        return feedbackRepository.save(existingFeedback);
    }

    @Override
    public void deleteFeedback(Long feedbackId) {
        feedbackRepository.deleteById(feedbackId);
    }

}
