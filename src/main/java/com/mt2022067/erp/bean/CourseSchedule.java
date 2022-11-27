package com.mt2022067.erp.bean;

import jakarta.persistence.*;

@Entity
@Table(name="course_schedule")
public class CourseSchedule {

    public Integer getId() {
        return id;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDay() {
        return Day;
    }

    public void setDay(String day) {
        Day = day;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(targetEntity = Course.class, cascade = CascadeType.ALL)
    private Course course;

    @Column(nullable = false)
    private String time;

    @Column(nullable = false)
    private String Day;

    @Column(nullable = false)
    private String room;

    private String building;
}
