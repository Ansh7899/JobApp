package com.example.JobApp.service;

import com.example.JobApp.model.Review;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ReviewService {
    List<Review> findAllReviews(Long companyId);
}
