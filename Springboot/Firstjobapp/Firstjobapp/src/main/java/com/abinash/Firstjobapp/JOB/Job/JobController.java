package com.abinash.Firstjobapp.JOB.Job;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class JobController {
private JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/jobs")
    public ResponseEntity <List<Job>>findAll(){

        return ResponseEntity.ok(jobService.findAll());
    }

    @PostMapping("/jobs")
    public ResponseEntity<String> CreateJob(@RequestBody Job job){
        jobService.createJob(job);
        return new ResponseEntity<>("Job added succesfully" , HttpStatus.OK);
    }

    @GetMapping("/jobs/{id}")
    public ResponseEntity<Job> getJobByID(@PathVariable Long id) {

        Job job = jobService.getJobByID(id) ;
        if(job != null)
        return new ResponseEntity<>(job , HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("jobs/{id}")
    public ResponseEntity<String > deleteJob(@PathVariable Long id) {
        boolean deleted = jobService.deleteJobById(id);
        if(deleted)
            return new ResponseEntity<>("job deleted succesfully" ,HttpStatus.OK);
        return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("jobs/{id}")
    public ResponseEntity<String>updateJob(@PathVariable Long id , @RequestBody Job updateJob){
        boolean updated = jobService.updateJobById(id, updateJob);
        if(updated)
            return new ResponseEntity<>("job updated succesfully" , HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

/*

GET /jobs: Get all jobs
GET /jobs/{id}: Get a specific job by IDx
POST /jobs: Create a new job (request body should contain the job details)
DELETE /jobs/{id}: Delete a Specific job by id
PUT /jobs/{id}: update a specific job by ID (request body should contain the update job details)

*/

