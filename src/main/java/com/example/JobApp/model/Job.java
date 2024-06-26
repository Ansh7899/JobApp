package com.example.JobApp.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

//    Many-to-one mapping added as many jobs can be linked to a single company
//    While creating job we can just pass id of the company and this mapping will automatically take care of the job to company mapping
    @ManyToOne
    private Company company;

}
