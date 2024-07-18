package com.example.Medilife_backend.Feedback.repository;

import com.example.Medilife_backend.Feedback.entity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepo extends JpaRepository<Feedback,Integer> {
}
