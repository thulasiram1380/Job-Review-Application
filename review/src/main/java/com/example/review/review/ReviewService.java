package com.example.review.review;


import java.util.List;

public interface ReviewService {
    List<Review> findAllReviews(Long companyId);
    boolean addReview(Long companyId , Review review);
    Review getReview(Long reviewId);
    boolean updateReview(Long reviewId , Review Updatedreview);

    boolean deleteReview(Long reviewId);
}
