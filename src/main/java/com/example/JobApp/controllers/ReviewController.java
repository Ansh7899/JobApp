package com.example.JobApp.controllers;

import com.example.JobApp.model.Review;
import com.example.JobApp.service.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies/{companyId}")
public class ReviewController {
    public ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getAllReviews(@PathVariable Long companyId) {
        List<Review> reviewList = reviewService.findAllReviews(companyId);
        if (!reviewList.isEmpty())
            return new ResponseEntity<>(reviewList,
                HttpStatus.OK);
        return new ResponseEntity<>(null,
                HttpStatus.NOT_FOUND);
    }

    @PostMapping("/reviews")
    public ResponseEntity<String> addReview(@PathVariable Long companyId
            , @RequestBody Review review) {
        Boolean reviewAdded = reviewService.addReviewForCompany(companyId, review);
        if (reviewAdded)
            return new ResponseEntity<>("Review added successfully",
                HttpStatus.CREATED);
        return new ResponseEntity<>("Review could not be added",
                HttpStatus.NOT_FOUND);
    }
}
