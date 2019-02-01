package com.wsh.entity;

public class Vacation {
    private Integer id;

    private String leaveId;

    private String stuId;

    private String stuName;

    private String applicationTime;

    private String startTime;

    private String endTime;

    private String leaveDay;

    private String approvalTea;

    private String status;

    private String leavecourseTea;

    private String leaveReason;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLeaveId() {
        return leaveId;
    }

    public void setLeaveId(String leaveId) {
        this.leaveId = leaveId == null ? null : leaveId.trim();
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId == null ? null : stuId.trim();
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName == null ? null : stuName.trim();
    }

    public String getApplicationTime() {
        return applicationTime;
    }

    public void setApplicationTime(String applicationTime) {
        this.applicationTime = applicationTime == null ? null : applicationTime.trim();
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime == null ? null : startTime.trim();
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime == null ? null : endTime.trim();
    }

    public String getLeaveDay() {
        return leaveDay;
    }

    public void setLeaveDay(String leaveDay) {
        this.leaveDay = leaveDay == null ? null : leaveDay.trim();
    }

    public String getApprovalTea() {
        return approvalTea;
    }

    public void setApprovalTea(String approvalTea) {
        this.approvalTea = approvalTea == null ? null : approvalTea.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getLeavecourseTea() {
        return leavecourseTea;
    }

    public void setLeavecourseTea(String leavecourseTea) {
        this.leavecourseTea = leavecourseTea == null ? null : leavecourseTea.trim();
    }

    public String getLeaveReason() {
        return leaveReason;
    }

    public void setLeaveReason(String leaveReason) {
        this.leaveReason = leaveReason == null ? null : leaveReason.trim();
    }
}