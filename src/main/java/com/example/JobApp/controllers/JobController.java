package com.example.JobApp.controllers;

import com.example.JobApp.model.Job;
import com.example.JobApp.service.JobService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {

    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping
    public ResponseEntity<List<Job>> findAll(){
        return new ResponseEntity<>(jobService.findAll()
                , HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Job> findByJobId(@PathVariable Long id){
        Job job = jobService.findJobById(id);
        if(job != null)
            return new ResponseEntity<>(job, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<String> createJob(@RequestBody Job job){
        jobService.createJob(job);
        return new ResponseEntity<>("Job added successfully"
                , HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteJobById(@PathVariable Long id){
        Boolean delete = jobService.deleteJob(id);
        if (delete)
            return new ResponseEntity<>("Job deleted successfully",
                    HttpStatus.OK);
        return new ResponseEntity<>("Job not found",
                HttpStatus.NOT_FOUND);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateJobById(@PathVariable Long id, @RequestBody Job job){
        Boolean update = jobService.updateJob(id, job);
        if (update)
            return new ResponseEntity<>("Job updated successfully",
                    HttpStatus.OK);
        return new ResponseEntity<>("Job not found",
                HttpStatus.NOT_FOUND);
    }
}
