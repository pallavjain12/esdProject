package com.mt2022067.erp.helper;

import com.mt2022067.erp.bean.Course;
import com.mt2022067.erp.bean.Student;
import com.mt2022067.erp.dao.DAOImplementation.CourseDAOImplementation;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

public class StudentHelper {
    public Object getStudentsListByCourseId(Integer courseId) {
        CourseDAOImplementation courseDAOImplementation = new CourseDAOImplementation();
        System.out.println("Paramenter Course ID is : " + courseId);
        Course course = courseDAOImplementation.getCourseByCourseId(courseId);
        System.out.println("Database courseId is : " + course.getId());
        List<Student> studentList = courseDAOImplementation.studentsListByCourseId(course);
        return arrangeStudentData(studentList);
    }

    private Object arrangeStudentData (List<Student> studentList) {
        System.out.println("NUmber of students enrolled are : " + studentList.size());
        JSONArray list = new JSONArray();
        for (Student student : studentList) {
            JSONObject obj = new JSONObject();
            obj.put("first_name", student.getFirstName());
            obj.put("last_name", student.getLastName());
            obj.put(("email"), student.getEmail());
            obj.put("roll_no", student.getRollNumber());
            list.put(obj);
        }
        System.out.println(list.toString());
        return list.toString();
    }
}
