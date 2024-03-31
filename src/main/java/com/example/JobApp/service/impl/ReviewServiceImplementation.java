package com.example.JobApp.service.impl;

import com.example.JobApp.model.Company;
import com.example.JobApp.model.Review;
import com.example.JobApp.repository.ReviewRepository;
import com.example.JobApp.service.CompanyService;
import com.example.JobApp.service.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImplementation implements ReviewService {
    private final ReviewRepository reviewRepository;
    private final CompanyService companyService;

    public ReviewServiceImplementation(ReviewRepository reviewRepository, CompanyService companyService) {
        this.reviewRepository = reviewRepository;
        this.companyService = companyService;
    }

    @Override
    public List<Review> findAllReviews(Long companyId) {
        return reviewRepository.findByCompanyId(companyId);
    }

    @Override
    public Boolean addReviewForCompany(Long companyId, Review review) {
        Company company = companyService.findCompanyById(companyId);
        if(company != null) {
            review.setCompany(company);
            reviewRepository.save(review);
            return true;
        }
        return false;
    }


}
