package com.example.JobApp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;

//    This means that it has a one-to-many relationship with Job table,
//    meaning one company can have several jobs
//    mapped by parameter basically tells that within the Job Entity, we have a field company which maps the relationship
//    JsonIgnore is used to remove the recursive calls between job and company dependencies
    @JsonIgnore
    @OneToMany(mappedBy = "company")
    private List<Job> jobs;

    @OneToMany(mappedBy = "company")
    private List<Review> reviews;

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
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
