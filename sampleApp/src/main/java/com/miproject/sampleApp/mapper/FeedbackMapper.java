package com.miproject.sampleApp.mapper;

import com.miproject.sampleApp.dto.FeedbackDTO;
import com.miproject.sampleApp.model.Feedback;

public class FeedbackMapper {

    public static Feedback toEntity(FeedbackDTO feedbackDTO){
        Feedback feedback = new Feedback();
        feedback.setFeedbackText(feedbackDTO.getFeedbackText());
        feedback.setRating(feedbackDTO.getRating());

        return feedback;
    }

    public static FeedbackDTO toDTO(Feedback feedback){
        FeedbackDTO feedbackDTO = new FeedbackDTO();
        feedbackDTO.setFeedbackId(feedback.getFeedbackId());
        feedbackDTO.setFeedbackText(feedback.getFeedbackText());
        feedbackDTO.setRating(feedback.getRating());

        return feedbackDTO;
    }

}
    
