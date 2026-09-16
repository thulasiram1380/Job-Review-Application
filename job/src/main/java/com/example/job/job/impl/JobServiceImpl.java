package com.example.job.job.impl;


import com.example.job.job.Job;
import com.example.job.job.JobRepo;
import com.example.job.job.JobService;
import com.example.job.job.client.CompanyClient;
import com.example.job.job.client.ReviewClient;
import com.example.job.job.dto.JobDTO;
import com.example.job.job.external.Company;
import com.example.job.job.external.Review;
import com.example.job.job.mapper.JobMapper;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JobServiceImpl implements JobService {

    //private List<Job> jobs = new ArrayList<>();
    //private Long nextId = 1L;

    private final JobRepo jobRepo;
    private final RestTemplate restTemplate;
    private final CompanyClient companyClient;
    private final ReviewClient reviewClient;

    public JobServiceImpl(JobRepo jobRepo, RestTemplate restTemplate, CompanyClient companyClient, ReviewClient reviewClient) {
        this.jobRepo = jobRepo;
        this.restTemplate = restTemplate;
        this.companyClient = companyClient;
        this.reviewClient = reviewClient;
    }

    @Override
    public List<JobDTO> findAll() {
        List<Job> jobs = jobRepo.findAll();

        return jobs.stream().map(this::convert)
                .collect(Collectors.toList());
    }
    public JobDTO convert(Job job){

//        System.out.println("========== DEBUG ==========");
//        System.out.println("Job ID      = " + job.getId());
//        System.out.println("Company ID  = " + job.getCompanyId());
//        System.out.println("===========================");

//        Company company = restTemplate.getForObject(
//                "http://COMPANY:8081/companies/"+ job.getCompanyId()
//                , Company.class);
        Company company = companyClient.getCompany(job.getCompanyId());

//        ResponseEntity<List<Review>> responseReview = restTemplate.exchange(
//                "http://REVIEW/review?companyId="+ job.getCompanyId(),
//                HttpMethod.GET,
//                null,
//                new ParameterizedTypeReference<List<Review>>() {});

        List<Review> reviews =  reviewClient.getReviews(job.getCompanyId());
        //List<Review> review = responseReview.getBody();

        JobDTO jobDTO = JobMapper.convert(job , company , reviews);

        //jobDTO.setCompany(company);
        return jobDTO;
    }
    @Override
    public void create(Job job) {
        //job.setId(nextId++);
        jobRepo.save(job);
    }

    @Override
    public JobDTO getJobById(Long id) {
        Job job = jobRepo.findById(id).orElse(null);
        return  convert(job);
    }

    @Override
    public boolean deleteJobById(Long id) {
        try{
            jobRepo.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean updateJob(Long jobId, Job job) {
        Optional<Job> jobOpt = jobRepo.findById(jobId);
        if(jobOpt.isPresent()){
            Job job1 = jobOpt.get();
            job1.setTitle(job.getTitle());
            job1.setDescription(job.getDescription());
            job1.setMinSalary(job.getMinSalary());
            job1.setMaxSalary(job.getMaxSalary());
            job1.setLocation(job.getLocation());
            jobRepo.save(job1);
            return true;
        }

        return false;
    }
}
