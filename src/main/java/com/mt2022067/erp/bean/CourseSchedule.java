package com.mt2022067.erp.bean;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="course_schedule")
public class CourseSchedule {
    @Id
    private Integer id;
}
