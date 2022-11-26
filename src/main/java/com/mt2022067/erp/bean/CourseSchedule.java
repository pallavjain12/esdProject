package com.mt2022067.erp.bean;

import jakarta.persistence.*;

import java.sql.Time;

@Entity
@Table(name="course_schedule")
public class CourseSchedule {

    @Id
    private Integer id;

    @OneToOne(targetEntity = Course.class, cascade = CascadeType.ALL)
    private Course course;

    @Column(nullable = false)
    private Time time;

    @Column(nullable = false)
    private String Day;

    @Column(nullable = false)
    private String room;

    private String building;
}
