package com.example.JobApp.model;

import jakarta.persistence.*;

@Entity
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String destination;
    private Integer minSalary;
    private Integer maxSalary;
    private String location;

//    this is needed by JPA to instantiate objects using retrieved data
    public Job() {

    }

    public Job(Integer id, String title, String destination,
               Integer minSalary, Integer maxSalary, String location) {
        this.id = id;
        this.title = title;
        this.destination = destination;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
        this.location = location;
    }

    public Integer getId() {
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

    public void setId(Integer id) {
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
}
