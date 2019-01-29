package com.wsh.entity;

public class Isgocourse {
    private Integer id;

    private String courseId;

    private String stuId;

    private String courseTeacher;

    private String isTruancy;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId == null ? null : courseId.trim();
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId == null ? null : stuId.trim();
    }

    public String getCourseTeacher() {
        return courseTeacher;
    }

    public void setCourseTeacher(String courseTeacher) {
        this.courseTeacher = courseTeacher == null ? null : courseTeacher.trim();
    }

    public String getIsTruancy() {
        return isTruancy;
    }

    public void setIsTruancy(String isTruancy) {
        this.isTruancy = isTruancy == null ? null : isTruancy.trim();
    }
}