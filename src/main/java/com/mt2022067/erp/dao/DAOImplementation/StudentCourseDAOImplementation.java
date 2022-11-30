package com.mt2022067.erp.dao.DAOImplementation;

import com.mt2022067.erp.bean.Course;
import com.mt2022067.erp.bean.Student;
import com.mt2022067.erp.bean.StudentCourse;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.ArrayList;
import java.util.List;

import static com.mt2022067.erp.util.EntityManagerUtil.getEntityManagerFactory;

public class StudentCourseDAOImplementation {
    EntityManager entityManager = getEntityManagerFactory().createEntityManager();

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
        return studentList;
    }

    public Student getStudentByStudentId(Integer student_id) {
        entityManager.getTransaction().begin();

        TypedQuery<Student> query = entityManager.createQuery(
                "SELECT e FROM Student e WHERE e.id = ?1", Student.class);
        Object student = query.setParameter(1, student_id).getSingleResult();

        entityManager.getTransaction().commit();
        return (Student) student;
    }
}
