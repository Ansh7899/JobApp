package com.example.JobApp.service;

import com.example.JobApp.model.Job;

import java.util.List;

public interface JobService {
    List<Job> findAll();
    Job findJobById(Integer id);
    void createJob(Job job);
    Boolean deleteJob(Integer id);
}
