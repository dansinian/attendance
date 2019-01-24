package com.wsh.entity;

public class CourseArrangement {
    private Integer id;

    private String carmId;

    private String carmTime;

    private String courseId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCarmId() {
        return carmId;
    }

    public void setCarmId(String carmId) {
        this.carmId = carmId == null ? null : carmId.trim();
    }

    public String getCarmTime() {
        return carmTime;
    }

    public void setCarmTime(String carmTime) {
        this.carmTime = carmTime == null ? null : carmTime.trim();
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId == null ? null : courseId.trim();
    }
}