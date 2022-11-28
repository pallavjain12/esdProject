package com.mt2022067.erp.helper;

import com.mt2022067.erp.bean.Course;
import com.mt2022067.erp.bean.CourseSchedule;
import com.mt2022067.erp.bean.Employee;
import com.mt2022067.erp.dao.DAOImplementation.CourseDAOImplementation;
import com.mt2022067.erp.dao.DAOImplementation.CourseScheduleImplementation;
import com.mt2022067.erp.dao.DAOImplementation.EmployeeDAOImplementation;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;
public class CourseScheduleHelper {
    public Object getCoursesByEmployeeEmail(String email) {
        Employee employee1 = new EmployeeDAOImplementation().checkEmployeeCredentials(email);
        List<Course> courseList = new CourseDAOImplementation().getCourseByEmployeeId(employee1);
        List<List<CourseSchedule>> courseScheduleList = new CourseScheduleImplementation().getCourseSchedule(courseList);
        System.out.println(courseScheduleList.size());
        if (courseScheduleList == null) {
            return null;
        }
        return arrangeInJsonObject(courseScheduleList);
    }

    public String arrangeInJsonObject(List<List<CourseSchedule>> list) {
        JSONArray masterList = new JSONArray();
        for (List<CourseSchedule> courseSchedules : list) {
            if (courseSchedules.size() == 0) { continue; }
            JSONArray array = new JSONArray();
            JSONObject courseObject = new JSONObject();
            Course course = courseSchedules.get(0).getCourse();
            courseObject.put("name", course.getName());
            courseObject.put("id", course.getId());
            courseObject.put("capacity", course.getCapacity());
            courseObject.put("year", course.getYear());
            for (CourseSchedule schedule : courseSchedules) {
                JSONObject scheduleObject = new JSONObject();
                scheduleObject.put("time", schedule.getTime());
                scheduleObject.put("day", schedule.getDay());
                scheduleObject.put("room", schedule.getRoom());
                scheduleObject.put("building", schedule.getBuilding());
                array.put(scheduleObject);
            }
            courseObject.put("schedules", array);
            masterList.put(courseObject);
        }
        return masterList.toString();
    }

    public static void main () {
        CourseScheduleHelper obj = new CourseScheduleHelper();
        System.out.println(obj.getCoursesByEmployeeEmail("1@gmail.com"));
    }
}
