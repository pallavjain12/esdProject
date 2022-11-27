package com.mt2022067.erp.dao;

import com.mt2022067.erp.bean.Employee;

public interface EmployeeDAO {
    Employee checkEmployeeCredentials(String email);
}
