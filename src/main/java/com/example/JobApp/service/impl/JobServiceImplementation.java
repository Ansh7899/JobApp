package com.example.JobApp.service.impl;

import com.example.JobApp.model.Job;
import com.example.JobApp.repository.JobRepository;
import com.example.JobApp.service.JobService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImplementation implements JobService {
    JobRepository jobRepository;

//    Since JobRepository is a bean managed by Spring at the run time, we are creating the
//    constructor so that Spring automatically injects it during runtime, and we don't have to
//    do it manually
    public JobServiceImplementation(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public Job findJobById(Long id) {
        return jobRepository.findById(id).orElse(null);
    }

    @Override
    public void createJob(Job job) {
        jobRepository.save(job);
    }

    @Override
    public Boolean deleteJob(Long id) {
        try {
            jobRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Boolean updateJob(Long id, Job updatedJob) {
        Optional<Job> jobOptional = jobRepository.findById(id);
            if (jobOptional.isPresent()) {
                Job job = jobOptional.get();
                job.setTitle(updatedJob.getTitle());
                job.setDestination(updatedJob.getDestination());
                job.setMaxSalary(updatedJob.getMaxSalary());
                job.setMinSalary(updatedJob.getMinSalary());
                job.setLocation(updatedJob.getLocation());
                job.setCompany(updatedJob.getCompany());
                jobRepository.save(job);
                return true;
            }
        return false;
    }

}
