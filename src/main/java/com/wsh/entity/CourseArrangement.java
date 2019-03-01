package com.wsh.entity;

public class CourseArrangement {
    private String carmId;

    private String courseId;

    private String courseName;

    private String courseWeek;

    private String courseTime;

    public String getCarmId() {
        return carmId;
    }

    public void setCarmId(String carmId) {
        this.carmId = carmId == null ? null : carmId.trim();
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId == null ? null : courseId.trim();
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName == null ? null : courseName.trim();
    }

    public String getCourseWeek() {
        return courseWeek;
    }

    public void setCourseWeek(String courseWeek) {
        this.courseWeek = courseWeek == null ? null : courseWeek.trim();
    }

    public String getCourseTime() {
        return courseTime;
    }

    public void setCourseTime(String courseTime) {
        this.courseTime = courseTime == null ? null : courseTime.trim();
    }
}