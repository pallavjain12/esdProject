package com.mt2022067.erp.controller;

import com.mt2022067.erp.bean.Employee;
import com.mt2022067.erp.helper.CourseScheduleHelper;
import com.mt2022067.erp.helper.EmployeeHelper;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/employee")
public class EmployeeController {

    @POST
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    public Response checkEmployeeCredentials(Employee employee) {
        Employee e = new EmployeeHelper().checkCredentials(employee);
        System.out.println("e is : " + e == null);
        int statusCode = (e == null) ? 401 : 200;
        return Response.status(statusCode).entity(e).build();
    }
    @GET
    @Path("/getCourseSchedulefor/{email}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCourseScheduleByEmployeeId(@PathParam("email") String email) {
        return Response.status(200).entity(new CourseScheduleHelper().getCoursesByEmployeeEmail(email)).build();
    }
}
