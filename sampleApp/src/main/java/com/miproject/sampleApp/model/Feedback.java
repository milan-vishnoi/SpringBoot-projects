package com.miproject.sampleApp.model;

import jakarta.persistence.*;

@Entity
@Table(name ="feedback")
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long feedbackId;

    @Column(name = "feedback_text", nullable = false)
    private String feedbackText;

    private float rating;

    public Feedback() {}

    public Feedback(String feedbackText, float rating) {
        this.feedbackText = feedbackText;
        this.rating = rating;
    }

    public Long getFeedbackId() {
        return feedbackId;
    }
    public void setFeedbackId(Long feedbackId) {
        this.feedbackId = feedbackId;
    }
    public String getFeedbackText() {
        return feedbackText;
    }
    public void setFeedbackText(String feedbackText) {
        this.feedbackText = feedbackText;
    }
    public float getRating() {
        return rating;
    }
    public void setRating(float rating) {
        this.rating = rating;
    }
    
}
