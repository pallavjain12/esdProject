package com.mt2022067.erp.controller;

import com.mt2022067.erp.bean.Employee;
import com.mt2022067.erp.dao.DAOImplementation.EmployeeDAOImplementation;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
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
        List<Employee> verifiedEmployee = new EmployeeDAOImplementation().checkEmployeeCredentials(employee.getEmail());

        if (verifiedEmployee.size() == 0) {
            return Response.status(203).build();
        }
        else {
            String email = verifiedEmployee.get(0).getEmail();
            String password = verifiedEmployee.get(0).getFirstName();
            return Response.status(200).entity(email + password).build();
        }
    }
}
