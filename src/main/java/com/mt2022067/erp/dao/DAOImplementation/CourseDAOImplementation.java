package com.mt2022067.erp.dao.DAOImplementation;

import com.mt2022067.erp.bean.Course;
import com.mt2022067.erp.bean.Employee;
import com.mt2022067.erp.bean.Student;
import com.mt2022067.erp.bean.StudentCourse;
import com.mt2022067.erp.dao.CourseDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.ArrayList;
import java.util.List;

public class CourseDAOImplementation implements CourseDAO {
    public List<Course> getCourseByEmployeeId(Employee employee) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Course> criteria = builder.createQuery(Course.class);
        Root<Course> root = criteria.from(Course.class);
        criteria.select(root);
        criteria.where(builder.equal(root.get("employee"), employee));
        List<Course> courseList = entityManager.createQuery(criteria).getResultList();
        entityManager.getTransaction().commit();
        return courseList;
    }
    public List<Student> studentsListByCourseId(Course course) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();

        CriteriaQuery<StudentCourse> criteria = builder.createQuery(StudentCourse.class);
        Root<StudentCourse> root = criteria.from(StudentCourse.class);
        criteria.select(root);
        criteria.where(builder.equal(root.get("course"), course));

        List<StudentCourse> list = entityManager.createQuery(criteria).getResultList();
        List<Student> studentList = new ArrayList<>();
        for (StudentCourse studentCourse : list) {
            studentList.add(studentCourse.getStudent());
        }
        return studentList;
    }
}
