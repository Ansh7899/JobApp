package com.example.JobApp.model;

import jakarta.persistence.*;

@Entity
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String destination;
    private Integer minSalary;
    private Integer maxSalary;
    private String location;

//    Many to one mapping added as many jobs can be linked to a single company
//    While creating job we can just pass id of the company and this mapping will automatically take care of the job to company mapping
    @ManyToOne
    private Company company;

//    this is needed by JPA to instantiate objects using retrieved data
    public Job() {

    }

    public Job(Long id, String title, String destination, Integer minSalary, Integer maxSalary, String location, Company company) {
        this.id = id;
        this.title = title;
        this.destination = destination;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
        this.location = location;
        this.company = company;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDestination() {
        return destination;
    }

    public Integer getMinSalary() {
        return minSalary;
    }

    public Integer getMaxSalary() {
        return maxSalary;
    }

    public String getLocation() {
        return location;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setMinSalary(Integer minSalary) {
        this.minSalary = minSalary;
    }

    public void setMaxSalary(Integer maxSalary) {
        this.maxSalary = maxSalary;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
