package com.example.job.job.client;

import com.example.job.job.external.Review;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name="REVIEW")
public interface ReviewClient {

    @GetMapping("/review")
    List<Review> getReviews(@RequestParam Long companyId);
}
