package com.mt2022067.erp.bean;

import jakarta.persistence.*;

@Entity
@Table(name="student_course")
public class StudentCourse {

    @Id
    @GeneratedValue
    private Integer id;

    @OneToOne(targetEntity = Student.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id")
    private Student student;

    @OneToOne(targetEntity = Course.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id")
    private Course course;

    private String Comments;
}
