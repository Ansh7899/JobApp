package com.example.JobApp.service;

import com.example.JobApp.model.Job;

import java.util.List;

public interface JobService {
    List<Job> findAll();

    void createJob(Job job);
}
