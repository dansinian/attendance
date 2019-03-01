package com.wsh.entity;

public class Question {
    private String queId;

    private String queTitle;

    private String queSummary;

    private String queDetail;

    private String userId;

    private String createTime;

    private Integer clickCount;

    private Integer praiseCount;

    private Integer replyCount;

    private String queCourse;

    public String getQueId() {
        return queId;
    }

    public void setQueId(String queId) {
        this.queId = queId == null ? null : queId.trim();
    }

    public String getQueTitle() {
        return queTitle;
    }

    public void setQueTitle(String queTitle) {
        this.queTitle = queTitle == null ? null : queTitle.trim();
    }

    public String getQueSummary() {
        return queSummary;
    }

    public void setQueSummary(String queSummary) {
        this.queSummary = queSummary == null ? null : queSummary.trim();
    }

    public String getQueDetail() {
        return queDetail;
    }

    public void setQueDetail(String queDetail) {
        this.queDetail = queDetail == null ? null : queDetail.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public Integer getClickCount() {
        return clickCount;
    }

    public void setClickCount(Integer clickCount) {
        this.clickCount = clickCount;
    }

    public Integer getPraiseCount() {
        return praiseCount;
    }

    public void setPraiseCount(Integer praiseCount) {
        this.praiseCount = praiseCount;
    }

    public Integer getReplyCount() {
        return replyCount;
    }

    public void setReplyCount(Integer replyCount) {
        this.replyCount = replyCount;
    }

    public String getQueCourse() {
        return queCourse;
    }

    public void setQueCourse(String queCourse) {
        this.queCourse = queCourse == null ? null : queCourse.trim();
    }
}
