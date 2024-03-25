package com.example.JobApp.service.impl;

import com.example.JobApp.model.Job;
import com.example.JobApp.service.JobService;
import org.springframework.boot.autoconfigure.integration.IntegrationAutoConfiguration;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobServiceImplementation implements JobService {

    private List<Job> jobs = new ArrayList<>();
    private Integer jobId = 1;

    @Override
    public List<Job> findAll() {
        return jobs;
    }

    @Override
    public void createJob(Job job) {
        job.setId(jobId++);
        jobs.add(job);
    }
}
