package com.example.job.job;

import com.example.job.job.dto.JobDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/jobs")
@RestController
public class JobController {


    private final JobService jobService;
    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping
    public ResponseEntity<List<JobDTO>> findAllJob(){
        return  new ResponseEntity<>(jobService.findAll(),  HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobDTO> findJobById(@PathVariable Long id) {
        JobDTO jobDTO = jobService.getJobById(id);
        if(jobDTO != null)
            return new  ResponseEntity<>(jobDTO, HttpStatus.OK);

        return new  ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<String> createJob(@RequestBody Job job){
        jobService.create(job);
        return new ResponseEntity<>("Successfully created " , HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJobById(@PathVariable Long id){
        boolean  deleted = jobService.deleteJobById(id);
        if(deleted){
            return new ResponseEntity<>("Successfully deleted " , HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //@PutMapping("/job/{id}")
    @RequestMapping (value = "/{id}" , method = RequestMethod.PUT)
    public ResponseEntity<String> updateJob(@PathVariable Long id ,
                            @RequestBody Job job){

        boolean updated = jobService.updateJob(id , job);
        if(updated){
            return new ResponseEntity<>("Successfully updated " , HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
}
