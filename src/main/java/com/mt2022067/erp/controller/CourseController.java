package com.mt2022067.erp.controller;

import com.mt2022067.erp.helper.StudentHelper;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

@Path("courses")
public class CourseController {

    @GET
    @Path("/students/{course}")
    public Response getStudentsByCourseId (@PathParam("course") Integer course) {
        return Response.status(200)
                .entity(new StudentHelper().getStudentsListByCourseId(course))
                .build();
    }
}
