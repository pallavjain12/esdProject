package com.mt2022067.erp.helper;

import com.mt2022067.erp.bean.Employee;
import com.mt2022067.erp.dao.DAOImplementation.EmployeeDAOImplementation;

public class EmployeeHelper {
    public Employee checkCredentials(Employee employee) {
        Employee employeeRetrieved = new EmployeeDAOImplementation().getEmployeeFromEmail(employee.getEmail());
        try {
            if (employeeRetrieved.getPassword().equals(employee.getPassword())) { return employeeRetrieved; }
            else { return null; }
        }
        catch(Exception e) {
            System.out.println("Error occurred while comparing employee login password\nError: " + e);
            return null;
        }
    }
}
