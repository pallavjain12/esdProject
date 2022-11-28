package com.mt2022067.erp.controller;

import com.mt2022067.erp.bean.Employee;
import com.mt2022067.erp.dao.DAOImplementation.EmployeeDAOImplementation;
import com.mt2022067.erp.helper.CourseScheduleHelper;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

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

        CourseScheduleHelper helper = new CourseScheduleHelper();
        return Response.status(200).entity(helper.getCoursesByEmployeeEmail(email)).build();
    }
}
