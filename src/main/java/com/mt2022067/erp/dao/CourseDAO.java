package com.mt2022067.erp.dao;

import com.mt2022067.erp.bean.Course;
import com.mt2022067.erp.bean.Employee;
import com.mt2022067.erp.bean.Student;

import java.util.List;
public interface CourseDAO {
    List<Course>  getCourseByEmployeeId(Employee employee);
    List<Student> studentsListByCourseId(Course course);
}
