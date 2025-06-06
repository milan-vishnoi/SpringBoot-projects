package com.miproject.sampleApp.model;

import jakarta.persistence.*;

@Entity
@Table(name ="feedback")
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "feedback_seq")
    @SequenceGenerator(name="feedback_seq",sequenceName="feedback_sequence", allocationSize=1)
    private Long feedbackId;

    @Column(name = "feedback_text", nullable = false)
    private String feedbackText;

    private Float rating;

    public Feedback() {}

    public Feedback(String feedbackText, Float rating) {
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
    public Float getRating() {
        return rating;
    }
    public void setRating(Float rating) {
        this.rating = rating;
    }
    
}
