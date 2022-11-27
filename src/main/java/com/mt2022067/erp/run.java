package com.mt2022067.erp;

import com.mt2022067.erp.bean.Course;
import com.mt2022067.erp.bean.Employee;
import com.mt2022067.erp.bean.Student;
import com.mt2022067.erp.dao.DAOImplementation.CourseDAOImplementation;
import com.mt2022067.erp.dao.DAOImplementation.EmployeeDAOImplementation;
import com.mt2022067.erp.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class run {
    public static void main(String[] args) {

        SessionFactory one = HibernateUtil.getSessionFactory();
        Session session = one.openSession();
        session.beginTransaction();

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

        Employee employee = new EmployeeDAOImplementation().checkEmployeeCredentials("email2@gmail.com");
        System.out.println(employee.getEmail());
        Employee emp = session.get(Employee.class, 2);
        System.out.println(emp.getEmail());
        CourseDAOImplementation im = new CourseDAOImplementation();
        List<Course> list = im.getCourseByEmployeeId(emp);
        System.out.println("Following courses are fetched");

        for (Course i : list) {
            System.out.println(i.getCourseCode());
        }
        System.out.println("now printing students enrolled in courses");
        System.out.println("Found" + list.size() + "courses under employee email " + emp.getEmail());
        for (Course course : list)  {
            System.out.println("Printing for course name = " + course.getName());
            List<Student> studentList = im.studentsListByCourseId(course);
            System.out.println("found " + studentList.size() + " students in course name = " + course.getName());
            for (Student student : studentList) {
                System.out.println(student.getEmail());
            }
        }
        session.close();
    }
}