package com.mt2022067.erp.dao;

import com.mt2022067.erp.bean.Course;
import com.mt2022067.erp.bean.Student;

import java.util.List;

public interface StudentCourseDAO {
    List<Student> studentsListByCourseId(Course course);
}
