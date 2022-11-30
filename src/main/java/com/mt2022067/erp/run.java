package com.mt2022067.erp;

import jakarta.persistence.EntityManager;

import static com.mt2022067.erp.util.EntityManagerUtil.getEntityManagerFactory;

public class run {
    public static void main(String[] args) {

        EntityManager entityManager = getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
    }
}