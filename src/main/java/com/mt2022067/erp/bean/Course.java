package com.mt2022067.erp.bean;

import jakarta.persistence.*;

@Entity
@Table(name="course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "course_code", unique = true, nullable = false)
    private String courseCode;

    @Column(nullable = false)
    private String name;

    private String description;

    @Column(nullable = false)
    private Integer year;

    @Column(nullable = false)
    private Integer term;

    @Column(nullable = false)
    private Integer credit;

    @Column(nullable = false)
    private Integer capacity;
}
