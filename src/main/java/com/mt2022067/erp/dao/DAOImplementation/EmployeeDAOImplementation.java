package com.mt2022067.erp.dao.DAOImplementation;

import com.mt2022067.erp.bean.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;

public class EmployeeDAOImplementation {
    public Employee checkEmployeeCredentials(String email) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Employee> criteria = builder.createQuery(Employee.class);
        Root<Employee> root = criteria.from(Employee.class);
        criteria.select(root);
        criteria.where(builder.equal(root.get("email"), email));
        List<Employee> courseList = entityManager.createQuery(criteria).getResultList();
        entityManager.getTransaction().commit();
        return courseList.get(0);
    }
}
