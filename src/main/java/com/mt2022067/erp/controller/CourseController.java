package com.mt2022067.erp.controller;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

public class CourseController {

    @GET
    @Path("/get-students-for/{course}")
    public Response getStudentsByCourseId (@PathParam("course") String course) {


        return Response.status(200).build();
    }
}
