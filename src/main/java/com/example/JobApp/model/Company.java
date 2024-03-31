package com.example.JobApp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;

//    This means that it has a one-to-many relationship with Job table
//    meaning one company can have several jobs
//    mapped by parameter basically tells that within the Job Entity, we have a field company which maps the relationship
//    JsonIgnore is used to remove the recursive calls between job and company dependencies
    @JsonIgnore
    @OneToMany(mappedBy = "company")
    private List<Job> jobs;


    public Company(){

    }

    public Company(long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }
}
