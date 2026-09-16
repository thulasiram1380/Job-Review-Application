package com.example.job.job;

import com.example.job.job.dto.JobDTO;

import java.util.List;

public interface JobService {

    List<JobDTO> findAll();

    void create(Job job);

    JobDTO getJobById(Long id);

    boolean deleteJobById(Long id);

    boolean updateJob(Long jobId, Job job);
}
