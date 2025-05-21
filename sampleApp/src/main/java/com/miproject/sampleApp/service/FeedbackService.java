package com.miproject.sampleApp.service;

import com.miproject.sampleApp.model.Feedback;
import java.util.List;

public interface FeedbackService {

    Feedback saveFeedback(Feedback feedback);
    List<Feedback> getAllFeedbacks();
    Feedback getFeedbackById(Long feedbackId);
    void deleteFeedback(Long feedbackId);
}
