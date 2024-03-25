package com.example.JobApp.service.impl;

import com.example.JobApp.model.Job;
import com.example.JobApp.service.JobService;
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
    public Job findJobById(Integer id) {
        for (Job job: jobs) {
            if (job.getId().equals(id))
                return job;
        }
        return null;
    }

    @Override
    public void createJob(Job job) {
        job.setId(jobId++);
        jobs.add(job);
    }

    @Override
    public Boolean deleteJob(Integer id) {

        for (Job job : jobs) {
            if (job.getId().equals(id)) {
                jobs.remove(id);
                return true;
            }
        }
        return false;
    }

    @Override
    public Boolean updateJob(Integer id, Job updatedJob) {

        for (Job job : jobs) {
            if (job.getId().equals(id)) {
                job.setTitle(updatedJob.getTitle());
                job.setDestination(updatedJob.getDestination());
                job.setMaxSalary(updatedJob.getMaxSalary());
                job.setMinSalary(updatedJob.getMinSalary());
                job.setLocation(updatedJob.getLocation());
                return true;
            }
        }
        return false;
    }

}
