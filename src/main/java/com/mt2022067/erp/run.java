package com.mt2022067.erp;

import com.mt2022067.erp.util.HibernateSessionUtil;
import org.hibernate.Session;
public class run {
    public static void main(String[] args) {
        Session one = HibernateSessionUtil.getSession();
    }
}