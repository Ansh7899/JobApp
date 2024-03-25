package com.example.JobApp.controllers;

import com.example.JobApp.model.Job;
import com.example.JobApp.service.JobService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.DeleteExchange;

import java.util.ArrayList;
import java.util.List;

@RestController
public class JobController {

    private JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/jobs")
    public ResponseEntity<List<Job>> findAll(){
        return new ResponseEntity<>(jobService.findAll()
                , HttpStatus.OK);
    }

    @GetMapping("/jobs/{id}")
    public ResponseEntity<Job> findByJobId(@PathVariable Integer id){
        Job job = jobService.findJobById(id);
        if(job != null)
            return new ResponseEntity<>(job, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/jobs")
    public ResponseEntity<String> createJob(@RequestBody Job job){
        jobService.createJob(job);
        return new ResponseEntity<>("Job added successfully"
                , HttpStatus.CREATED);
    }

    @DeleteMapping("deletejob/{id}")
    public ResponseEntity<String> deleteJobById(@PathVariable Integer id){
        Boolean delete = jobService.deleteJob(id);
        if (delete)
            return new ResponseEntity<>("Job deleted successfully",
                    HttpStatus.OK);
        return new ResponseEntity<>("Job not found",
                HttpStatus.NOT_FOUND);
    }
}
