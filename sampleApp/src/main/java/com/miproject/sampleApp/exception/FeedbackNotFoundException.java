package com.miproject.sampleApp.exception;

public class FeedbackNotFoundException extends RuntimeException {

    public FeedbackNotFoundException(Long id){
        super("Feedback not found for id:"+id);
    }
    
}
