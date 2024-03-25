package com.example.JobApp.model;

public class Job {

    private Integer id;
    private String title;
    private String detination;
    private Integer minSalary;
    private Integer maxSalary;
    private String location;

    public Job(Integer id, String title, String detination,
               Integer minSalary, Integer maxSalary, String location) {
        this.id = id;
        this.title = title;
        this.detination = detination;
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

    public String getDetination() {
        return detination;
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

    public void setDetination(String detination) {
        this.detination = detination;
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
