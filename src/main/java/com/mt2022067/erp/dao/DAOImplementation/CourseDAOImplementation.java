package com.mt2022067.erp.dao.DAOImplementation;

import com.mt2022067.erp.bean.Course;
import com.mt2022067.erp.bean.Employee;
import com.mt2022067.erp.bean.Student;
import com.mt2022067.erp.bean.StudentCourse;
import com.mt2022067.erp.dao.CourseDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.ArrayList;
import java.util.List;

import static com.mt2022067.erp.util.EntityManagerUtil.getEntityManagerFactory;

public class CourseDAOImplementation implements CourseDAO {
    EntityManager entityManager = getEntityManagerFactory().createEntityManager();

    public List<Course> getCourseByEmployeeId(Employee employee) {
        entityManager.getTransaction().begin();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Course> criteria = builder.createQuery(Course.class);
        Root<Course> root = criteria.from(Course.class);
        criteria.select(root);
        criteria.where(builder.equal(root.get("employee"), employee));
        List<Course> courseList = entityManager.createQuery(criteria).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return courseList;
    }
    public List<Student> studentsListByCourseId(Course course) {

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
        entityManager.getTransaction().commit();
        entityManager.close();
        return studentList;
    }

    public Course getCourseByCourseId(Integer courseId) {
        entityManager.getTransaction().begin();
        TypedQuery<Course> query = entityManager.createQuery("SELECT e FROM Course e WHERE e.id = ?1", Course.class);
        Object course = query.setParameter(1, courseId).getSingleResult();
        entityManager.getTransaction().commit();
        return (Course)course;
    }
}
