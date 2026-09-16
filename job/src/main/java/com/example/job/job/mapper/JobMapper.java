package com.example.job.job.mapper;

import com.example.job.job.Job;
import com.example.job.job.dto.JobDTO;
import com.example.job.job.external.Company;
import com.example.job.job.external.Review;

import java.util.List;

public class JobMapper {

    public static JobDTO convert(Job job , Company company , List<Review> reviews) {
        JobDTO jobDTO = new JobDTO();
        jobDTO.setId(job.getId());
        jobDTO.setTitle(job.getTitle());
        jobDTO.setDescription(job.getDescription());
        jobDTO.setLocation(job.getLocation());
        jobDTO.setMaxSalary(job.getMaxSalary());
        jobDTO.setMinSalary(job.getMinSalary());
        jobDTO.setCompany(company);
        jobDTO.setReviews(reviews);

        return jobDTO;
    }
}
