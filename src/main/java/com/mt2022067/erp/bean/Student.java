package com.mt2022067.erp.bean;

import jakarta.persistence.*;

@Entity
@Table(name="student")
public class Student {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name="roll_number", unique = true, nullable = false)
    private String rollNumber;

    @Column(name="first_name", nullable = false)
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(name="photographgraph_path")
    private String photographPath;

    @Column(nullable = false, columnDefinition = "integer default 0")
    private Integer cgpa;

    @Column(name = "total_credits",nullable = false)
    private Integer totalCredits;

    @Column(name = "graduation_year")
    private Integer graduationYear;

    @OneToOne(targetEntity = Specialization.class, cascade = CascadeType.ALL)
    private Specialization specialization;
}
