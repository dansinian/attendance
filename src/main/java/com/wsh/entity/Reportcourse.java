package com.wsh.entity;

public class Reportcourse {
    private Integer id;

    private String stuId;

    private String reportCourse;

    private String reportWeek;

    private String reportTime;

    private String reportDay;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId == null ? null : stuId.trim();
    }

    public String getReportCourse() {
        return reportCourse;
    }

    public void setReportCourse(String reportCourse) {
        this.reportCourse = reportCourse == null ? null : reportCourse.trim();
    }

    public String getReportWeek() {
        return reportWeek;
    }

    public void setReportWeek(String reportWeek) {
        this.reportWeek = reportWeek == null ? null : reportWeek.trim();
    }

    public String getReportTime() {
        return reportTime;
    }

    public void setReportTime(String reportTime) {
        this.reportTime = reportTime == null ? null : reportTime.trim();
    }

    public String getReportDay() {
        return reportDay;
    }

    public void setReportDay(String reportDay) {
        this.reportDay = reportDay == null ? null : reportDay.trim();
    }
}
