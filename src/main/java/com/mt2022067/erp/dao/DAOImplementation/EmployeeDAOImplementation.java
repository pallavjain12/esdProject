package com.mt2022067.erp.dao.DAOImplementation;

import com.mt2022067.erp.bean.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;

import static com.mt2022067.erp.util.EntityManagerUtil.getEntityManagerFactory;

public class EmployeeDAOImplementation {
    public List<Employee> checkEmployeeCredentials(String email) {
        System.out.println("came in dao");
        System.out.println(email);
        EntityManager entityManager = getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Employee> criteria = builder.createQuery(Employee.class);
        Root<Employee> root = criteria.from(Employee.class);
        criteria.select(root);
        criteria.where(builder.equal(root.get("email"), email));
        List<Employee> courseList = entityManager.createQuery(criteria).getResultList();
        System.out.println(courseList.size());
        entityManager.getTransaction().commit();
        entityManager.close();
        return courseList;
    }
}
