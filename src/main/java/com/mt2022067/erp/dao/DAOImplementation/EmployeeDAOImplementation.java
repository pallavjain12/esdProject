package com.mt2022067.erp.dao.DAOImplementation;

import com.mt2022067.erp.bean.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import static com.mt2022067.erp.util.EntityManagerUtil.getEntityManagerFactory;

public class EmployeeDAOImplementation {
    public Employee checkEmployeeCredentials(String email) {
        EntityManager entityManager = getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Employee> criteria = builder.createQuery(Employee.class);
        Root<Employee> root = criteria.from(Employee.class);
        criteria.select(root);
        criteria.where(builder.equal(root.get("email"), email));
        TypedQuery<Employee> query = entityManager.createQuery(
                "SELECT e FROM Employee e WHERE e.email = ?1", Employee.class);
        Object employee = query.setParameter(1, email).getSingleResult();
        return (Employee) employee;
    }
}
