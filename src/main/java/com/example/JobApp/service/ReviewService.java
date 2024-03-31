package com.example.JobApp.service;

import com.example.JobApp.model.Review;

import java.util.List;

public interface ReviewService {
    List<Review> findAllReviews(Long companyId);

    Boolean addReviewForCompany(Long companyId, Review review);
}
