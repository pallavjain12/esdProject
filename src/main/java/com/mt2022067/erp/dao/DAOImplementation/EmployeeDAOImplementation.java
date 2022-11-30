package com.mt2022067.erp.dao.DAOImplementation;

import com.mt2022067.erp.bean.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import static com.mt2022067.erp.util.EntityManagerUtil.getEntityManagerFactory;

public class EmployeeDAOImplementation {

    EntityManager entityManager = getEntityManagerFactory().createEntityManager();
    public Employee getEmployeeFromEmail(String email) {
        entityManager.getTransaction().begin();

        TypedQuery<Employee> query = entityManager.createQuery(
                "SELECT e FROM Employee e WHERE e.email = ?1", Employee.class);
        Object employee;
        try {
            employee = query.setParameter(1, email).getSingleResult();
        }
        catch(Exception e) {    System.out.println("Error occurred while fetching employee.\nError : " + e); return null;}
        entityManager.close();
        return (Employee) employee;
    }
}
