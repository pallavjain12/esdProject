package com.mt2022067.erp.dao.DAOImplementation;

import com.mt2022067.erp.bean.Course;
import com.mt2022067.erp.bean.CourseSchedule;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.ArrayList;
import java.util.List;

public class CourseScheduleImplementation {
    public List<CourseSchedule> getCourseSchedule(List<Course> coursesList) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();

        CriteriaQuery<CourseSchedule> criteria = builder.createQuery(CourseSchedule.class);
        Root<CourseSchedule> root = criteria.from(CourseSchedule.class);
        criteria.select(root);
        List<CourseSchedule> courseScheduleList = new ArrayList<>();

        for (Course course : coursesList) {
            criteria.where(builder.equal(root.get("course"), course));
            List<CourseSchedule> temp = entityManager.createQuery(criteria).getResultList();
            if (temp != null) {
                courseScheduleList.addAll((temp));
            }
        }
        return courseScheduleList;
    }
}
