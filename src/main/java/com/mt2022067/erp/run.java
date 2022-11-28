package com.mt2022067.erp;

import com.mt2022067.erp.helper.CourseScheduleHelper;
import jakarta.persistence.EntityManager;

import static com.mt2022067.erp.util.EntityManagerUtil.getEntityManagerFactory;

public class run {
    public static void main(String[] args) {

        EntityManager entityManager = getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        CourseScheduleHelper temp = new CourseScheduleHelper();
        System.out.println(temp.getCoursesByEmployeeEmail("1@gmail.com").toString());
    }
}