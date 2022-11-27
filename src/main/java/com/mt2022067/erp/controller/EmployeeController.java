package com.mt2022067.erp.controller;

import com.mt2022067.erp.bean.Course;
import com.mt2022067.erp.bean.CourseSchedule;
import com.mt2022067.erp.bean.Employee;
import com.mt2022067.erp.dao.DAOImplementation.CourseDAOImplementation;
import com.mt2022067.erp.dao.DAOImplementation.CourseScheduleImplementation;
import com.mt2022067.erp.dao.DAOImplementation.EmployeeDAOImplementation;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/employee")
public class EmployeeController {

    @POST
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    public Response checkEmployeeCredentials(Employee employee) {
        System.out.println(employee.getEmail());
        Employee verifiedEmployee = new EmployeeDAOImplementation().checkEmployeeCredentials(employee.getEmail());

        if (verifiedEmployee == null) {
            return Response.status(203).build();
        }
        else {
            return Response.status(200).entity(verifiedEmployee).build();
        }
    }
    @GET
    @Path("/getCourseSchedulefor/{email}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCourseScheduleByEmployeeId(@PathParam("email") String email) {
        // System.out.println(employee.getEmail());
        Employee employee1 = new EmployeeDAOImplementation().checkEmployeeCredentials(email);
        List<Course> courseList = new CourseDAOImplementation().getCourseByEmployeeId(employee1);
        List<List<CourseSchedule>> courseScheduleList = new CourseScheduleImplementation().getCourseSchedule(courseList);
        System.out.println(courseScheduleList.size());
        if (courseScheduleList == null) {
            return Response.status(200).entity("No schedule Found").build();
        }
        System.out.println(courseScheduleList.size());
        return Response.status(200).entity(courseScheduleList).build();
    }
}
