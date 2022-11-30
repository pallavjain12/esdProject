package com.mt2022067.erp.dao.DAOImplementation;

import com.mt2022067.erp.bean.Course;
import com.mt2022067.erp.bean.Specialization;
import com.mt2022067.erp.dao.SpecializationDAO;
import jakarta.persistence.EntityManager;

import java.util.ArrayList;
import java.util.List;

import static com.mt2022067.erp.util.EntityManagerUtil.getEntityManagerFactory;

public class SpecializationDAOImplementation implements SpecializationDAO {

    EntityManager entityManager = getEntityManagerFactory().createEntityManager();

    public List<Specialization> getSpecializationsFromCourse(Course course) {
        List<Specialization> specializationList = new ArrayList<>(course.getSpecializationSet());
        return specializationList;
    }
}
