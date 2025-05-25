package com.miproject.sampleApp.dto;

public class FeedbackDTO {
    private Long feedbackId;
    private String feedbackText;
    private Float rating;

    public Long getFeedbackId() {
        return feedbackId;
    }

    public String getFeedbackText() {
        return feedbackText;
    }

    public Float getRating() {
        return rating;
    }

    public void setFeedbackId(Long feedbackId) {
        this.feedbackId = feedbackId;
    }

    public void setFeedbackText(String feedbackText) {
        this.feedbackText = feedbackText;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

}
