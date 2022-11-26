package com.mt2022067.erp.bean;

import jakarta.persistence.*;

@Entity
@Table(name="student_course")
public class StudentCourse {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

}
