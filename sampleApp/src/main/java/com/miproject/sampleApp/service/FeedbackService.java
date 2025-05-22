package com.miproject.sampleApp.service;

import com.miproject.sampleApp.model.Feedback;
import java.util.List;

public interface FeedbackService {

    Feedback saveFeedback(Feedback feedback);
    List<Feedback> getAllFeedbacks();
    Feedback getFeedbackById(Long feedbackId);
    Feedback updateFeedback(Long feedbackId, Feedback updateFeedback );
    Feedback patchFeedback(Long feedbackId, Feedback updateFeedback);
    void deleteFeedback(Long feedbackId);
}
