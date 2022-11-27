package com.mt2022067.erp;

import jakarta.persistence.EntityManager;

import static com.mt2022067.erp.util.EntityManagerUtil.getEntityManagerFactory;

public class run {
    public static void main(String[] args) {

        EntityManager entityManager = getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.close();

//        SessionFactory one = HibernateUtil.getSessionFactory();
//        Session session = one.openSession();
//        session.beginTransaction();
//
//        Employee employee = new Employee();
//        employee.setFirstName("run2 first naem");
//        employee.setEmail("ru1sn@gmial.com");
//        employee.setTitle("faculty");
//
//        session.persist(employee);
//
//        Course course1 = new Course();
//        course1.setCapacity(4);
//        course1.setCourseCode("ai69");
//        course1.setCredit(4);
//        course1.setName("next");
//        course1.setTerm(3);
//        course1.setYear(7);
//        course1.setEmployee(employee);
//
//        session.persist(course1);
//        session.getTransaction().commit();
//        System.out.println("saved successfully");
//
//        List<Employee> emp = new EmployeeDAOImplementation().checkEmployeeCredentials("ru1sn@gmial.com");
//        System.out.println(emp.getEmail());
//        System.out.println(emp.getEmail());
//        CourseDAOImplementation im = new CourseDAOImplementation();
//        List<Course> list = im.getCourseByEmployeeId(emp);
//        System.out.println("Following courses are fetched");
//
//        for (Course i : list) {
//            System.out.println(i.getCourseCode());
//        }
//        System.out.println("now printing students enrolled in courses");
//        System.out.println("Found" + list.size() + "courses under employee email " + emp.getEmail());
//        for (Course course : list)  {
//            System.out.println("Printing for course name = " + course.getName());
//            List<Student> studentList = im.studentsListByCourseId(course);
//            System.out.println("found " + studentList.size() + " students in course name = " + course.getName());
//            for (Student student : studentList) {
//                System.out.println(student.getEmail());
//            }
//        }
    }
}