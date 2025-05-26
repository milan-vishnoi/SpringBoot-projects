package com.miproject.sampleApp.dto;

import jakarta.validation.constraints.*;

public class FeedbackDTO {
    private Long feedbackId;

    @NotBlank(message = "The feedback text can't be blank")
    private String feedbackText;

    @NotNull(message = "You must give a rating")
    @DecimalMin(value = "0.0",inclusive=true,message = "Ratings cannot be less than 0")
    @DecimalMax(value = "10.0",inclusive = true, message = "Max rating you can give is 10")
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
