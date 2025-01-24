package com.example.leave;

public class Student {
    private Integer id;
    private String studentID;
    private String name;
    private String date;
    private String reason;
    private String course;
    private String section;

    public Student() {
    }

    public Student(Integer id, String studentID, String name, String date, String reason, String course, String section) {
        this.id = id;
        this.studentID = studentID;
        this.name = name;
        this.date = date;
        this.reason = reason;
        this.course = course;
        this.section = section;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }
}
