package com.wsh.entity;

public class Teacher {
    private String teaId;

    private String teaName;

    private String teaPhone;

    private String teaPass;

    private String teaCourse;

    private String teaClass;

    private String teaDepartment;

    private String teaHeadImg;

    private String teaNickname;

    public String getTeaId() {
        return teaId;
    }

    public void setTeaId(String teaId) {
        this.teaId = teaId == null ? null : teaId.trim();
    }

    public String getTeaName() {
        return teaName;
    }

    public void setTeaName(String teaName) {
        this.teaName = teaName == null ? null : teaName.trim();
    }

    public String getTeaPhone() {
        return teaPhone;
    }

    public void setTeaPhone(String teaPhone) {
        this.teaPhone = teaPhone == null ? null : teaPhone.trim();
    }

    public String getTeaPass() {
        return teaPass;
    }

    public void setTeaPass(String teaPass) {
        this.teaPass = teaPass == null ? null : teaPass.trim();
    }

    public String getTeaCourse() {
        return teaCourse;
    }

    public void setTeaCourse(String teaCourse) {
        this.teaCourse = teaCourse == null ? null : teaCourse.trim();
    }

    public String getTeaClass() {
        return teaClass;
    }

    public void setTeaClass(String teaClass) {
        this.teaClass = teaClass == null ? null : teaClass.trim();
    }

    public String getTeaDepartment() {
        return teaDepartment;
    }

    public void setTeaDepartment(String teaDepartment) {
        this.teaDepartment = teaDepartment == null ? null : teaDepartment.trim();
    }

    public String getTeaHeadImg() {
        return teaHeadImg;
    }

    public void setTeaHeadImg(String teaHeadImg) {
        this.teaHeadImg = teaHeadImg == null ? null : teaHeadImg.trim();
    }

    public String getTeaNickname() {
        return teaNickname;
    }

    public void setTeaNickname(String teaNickname) {
        this.teaNickname = teaNickname == null ? null : teaNickname.trim();
    }
}