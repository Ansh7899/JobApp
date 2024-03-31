package com.example.JobApp.service;

import com.example.JobApp.model.Job;

import java.util.List;

public interface JobService {
    List<Job> findAll();
    Job findJobById(Long id);
    void createJob(Job job);
    Boolean deleteJob(Long id);
    Boolean updateJob(Long id, Job job);
}
