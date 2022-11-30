package com.mt2022067.erp.helper;

import com.mt2022067.erp.bean.Course;
import com.mt2022067.erp.bean.CourseSchedule;
import com.mt2022067.erp.bean.Employee;
import com.mt2022067.erp.bean.Specialization;
import com.mt2022067.erp.dao.DAOImplementation.CourseDAOImplementation;
import com.mt2022067.erp.dao.DAOImplementation.CourseScheduleImplementation;
import com.mt2022067.erp.dao.DAOImplementation.EmployeeDAOImplementation;
import com.mt2022067.erp.dao.DAOImplementation.SpecializationDAOImplementation;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;
public class CourseScheduleHelper {
    public Object getCoursesByEmployeeEmail(String email) {
        Employee employee1 = new EmployeeDAOImplementation().getEmployeeFromEmail(email);
        List<Course> courseList = new CourseDAOImplementation().getCourseByEmployeeId(employee1);
        return arrangeInJsonObject(courseList);
    }

    public String arrangeInJsonObject(List<Course> courseList) {
        JSONArray masterList = new JSONArray();

        for (Course course : courseList) {
            List<CourseSchedule> scheduleList = new CourseScheduleImplementation().getCourseSchedule(course);

            JSONArray array = new JSONArray();
            JSONObject courseObject = new JSONObject();
            courseObject.put("name", course.getName());
            courseObject.put("id", course.getId());
            courseObject.put("capacity", course.getCapacity());
            courseObject.put("year", course.getYear());
            for (CourseSchedule schedule : scheduleList) {
                JSONObject scheduleObject = new JSONObject();
                scheduleObject.put("time", schedule.getTime());
                scheduleObject.put("day", schedule.getDay());
                scheduleObject.put("room", schedule.getRoom());
                scheduleObject.put("building", schedule.getBuilding());
                array.put(scheduleObject);
            }
            courseObject.put("schedules", array);
            JSONArray specializationArray = new JSONArray();
            List<Specialization> specializationList = new SpecializationDAOImplementation().getSpecializationsFromCourse(course);
            for (Specialization specialization : specializationList) {
                JSONObject spec = new JSONObject();
                spec.put("name", specialization.getName());
                spec.put("code", specialization.getCode());
                specializationArray.put(spec);
            }
            courseObject.put("specializations", specializationArray);
            masterList.put(courseObject);
        }
        return masterList.toString();
    }

    public static void main () {
        CourseScheduleHelper obj = new CourseScheduleHelper();
        System.out.println(obj.getCoursesByEmployeeEmail("1@gmail.com"));
    }
}
