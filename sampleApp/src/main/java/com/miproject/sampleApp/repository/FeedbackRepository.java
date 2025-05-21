package com.miproject.sampleApp.repository;

import com.miproject.sampleApp.model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
    
}
