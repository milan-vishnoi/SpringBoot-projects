package com.miproject.sampleApp.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(FeedbackNotFoundException.class)
    public ResponseEntity<Map<String,Object>> handleFeedbackNotFoundException(FeedbackNotFoundException exception){
        Map<String,Object> errorBody = new HashMap<>();
        errorBody.put("timestamp", LocalDateTime.now());
        errorBody.put("message",exception.getMessage());
        errorBody.put("status",HttpStatus.NOT_FOUND.value());

        return new ResponseEntity<>(errorBody,HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Map<String,Object>> handleOtherExceptions(Exception exception){
        Map<String,Object> errorBody = new HashMap<>();
        errorBody.put("timestamp",LocalDateTime.now());
        errorBody.put("message",exception.getMessage());
        errorBody.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());

        return new ResponseEntity<>(errorBody,HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
}
