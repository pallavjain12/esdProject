package com.mt2022067.erp.dao;

import com.mt2022067.erp.bean.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> checkEmployeeCredentials(String email);
}
