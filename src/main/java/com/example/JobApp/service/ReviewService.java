package com.example.JobApp.service;

import com.example.JobApp.model.Review;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ReviewService {
    List<Review> findAllReviews(Long companyId);

    Boolean addReviewForCompany(Long companyId, Review review);

    Review getSpecificReview(Long companyId, Long reviewId);

    Boolean updateReviewById(Long companyId, Long reviewId, Review review);

    Boolean deleteReviewById(Long companyId, Long reviewId);
}
