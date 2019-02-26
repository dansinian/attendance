package com.wsh.entity;

public class QuestionWithBLOBs extends Question {
    private String queTitle;

    private String queSummary;

    private String queDetail;

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
}