package com.mt2022067.erp.dao;

import com.mt2022067.erp.bean.CourseSchedule;
import com.mt2022067.erp.bean.Course;

import java.util.*;

public interface CourseScheduleDAO {
    List<CourseSchedule> getScheduleByCourseId(Course course);
}
