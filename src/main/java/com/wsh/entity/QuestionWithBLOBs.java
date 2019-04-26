package com.wsh.entity;

public class QuestionWithBLOBs extends Question {
    private String queSummary;

    private String queDetail;

    private byte[] queImg;

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

    public byte[] getQueImg() {
        return queImg;
    }

    public void setQueImg(byte[] queImg) {
        this.queImg = queImg;
    }
}