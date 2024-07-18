package com.example.Medilife_backend.Feedback.service;

import com.example.Medilife_backend.Feedback.entity.Feedback;
import com.example.Medilife_backend.Feedback.repository.FeedbackRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class feedbackService {

    @Autowired
    FeedbackRepo feedbackRepo;

    public Feedback createFeedback(Feedback feedback) {
        return feedbackRepo.save(feedback);
    }

    public List<Feedback> allFeedback() {
        return feedbackRepo.findAll();
    }
}
