package com.example.Medilife_backend.Feedback.controller;

import com.example.Medilife_backend.Feedback.entity.Feedback;
import com.example.Medilife_backend.Feedback.service.feedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/medilife")
@CrossOrigin(origins = "http://localhost:3000")
public class FeedbackController {

    @Autowired
    feedbackService feedbackService;

    @PostMapping("/addFeedback")
    public Feedback addFeedback(@RequestBody Feedback feedback){
        return feedbackService.createFeedback(feedback);
    }

    @GetMapping("/allFeedback")
    public List<Feedback> allFeedback(){
        return feedbackService.allFeedback();
    }
}
