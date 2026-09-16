package com.example.review.review.impl;


import com.example.review.review.Review;
import com.example.review.review.ReviewRepo;
import com.example.review.review.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepo reviewRepo;


    public ReviewServiceImpl(ReviewRepo reviewRepo) {
        this.reviewRepo = reviewRepo;
    }

    @Override
    public List<Review> findAllReviews(Long companyId) {
        List<Review> reviews = reviewRepo.findByCompanyId(companyId);
        return reviews;
    }

    @Override
    public boolean addReview(Long companyId, Review review) {

        if(companyId != null && review != null){
            review.setCompanyId(companyId);
            reviewRepo.save(review);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Review getReview(Long reviewId) {
        return reviewRepo.findById(reviewId).orElse(null);
    }

    @Override
    public boolean updateReview(Long reviewId, Review Updatedreview) {
        Review review = reviewRepo.findById(reviewId).orElse(null);
        if(review != null){
            review.setTitle(Updatedreview.getTitle());
            review.setDescription(Updatedreview.getDescription());
            review.setRating(Updatedreview.getRating());
            review.setCompanyId(Updatedreview.getCompanyId());
            reviewRepo.save(review);
            return true;
        }else
            return false;

    }

    @Override
    public boolean deleteReview(Long reviewId) {
        Review review = reviewRepo.findById(reviewId).orElse(null);
        if(review != null){
            reviewRepo.deleteById(reviewId);
            return true;
        }else
            return false;
    }

}
