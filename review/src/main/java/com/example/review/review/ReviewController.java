package com.example.review.review;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/review")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }


    @GetMapping
    public ResponseEntity<List<Review>> findAllReviewsByCompanyId(@RequestParam Long companyId) {
        return new ResponseEntity<>(reviewService.findAllReviews(companyId),
                HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> addReview(@RequestParam Long companyId,
                                            @RequestBody Review review) {
        boolean exists = reviewService.addReview(companyId, review);
        if(exists){
            return new ResponseEntity<>("Review added successfully", HttpStatus.OK);
        }else
            return new ResponseEntity<>("Review Not Save", HttpStatus.NOT_FOUND);

    }

    @GetMapping("/{reviewId}")
    public ResponseEntity<Review> getReview(@PathVariable Long reviewId) {
        return new ResponseEntity<>(reviewService.getReview(reviewId), HttpStatus.OK);
    }

    @PutMapping("/{reviewId}")
    public ResponseEntity<String> updateReview(@PathVariable Long reviewId,
                                               @RequestBody Review review) {
        boolean re = reviewService.updateReview(reviewId, review);

        if(re)
            return new ResponseEntity<>("Updated successfully", HttpStatus.OK);
        else
            return new ResponseEntity<>("Review Not Update", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{reviewId}")
    public ResponseEntity<String> deleteReview(@PathVariable Long reviewId) {
        boolean isReview = reviewService.deleteReview(reviewId);

        if(isReview)
            return new ResponseEntity<>("Updated successfully", HttpStatus.OK);
        else
            return new ResponseEntity<>("Review Not Update", HttpStatus.NOT_FOUND);
    }

}
