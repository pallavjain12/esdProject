package com.mt2022067.erp.dao.DAOImplementation;

import com.mt2022067.erp.bean.Course;
import com.mt2022067.erp.bean.CourseSchedule;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;

import static com.mt2022067.erp.util.EntityManagerUtil.getEntityManagerFactory;

public class CourseScheduleImplementation {
    public List<CourseSchedule> getCourseSchedule(Course course) {
        EntityManager entityManager = getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();

        CriteriaQuery<CourseSchedule> criteria = builder.createQuery(CourseSchedule.class);
        Root<CourseSchedule> root = criteria.from(CourseSchedule.class);
        criteria.select(root);

        criteria.where(builder.equal(root.get("course"), course));
        List<CourseSchedule> courseScheduleList;
        try {
            courseScheduleList = entityManager.createQuery(criteria).getResultList();
        }
        catch (Exception e) {
            System.out.println("No course schedules for course " + course.getName());
            courseScheduleList = null;
        }
        entityManager.close();
        entityManager.getTransaction().commit();
        return courseScheduleList;
    }
}
