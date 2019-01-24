package com.wsh.entity;

public class Teacher {
    private Integer id;

    private String teaId;

    private String teaName;

    private String teaGender;

    private String teaDepartment;

    private String teaPhone;

    private String teaFlag;

    private String teaPassword;

    private String teaClass;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public String getTeaGender() {
        return teaGender;
    }

    public void setTeaGender(String teaGender) {
        this.teaGender = teaGender == null ? null : teaGender.trim();
    }

    public String getTeaDepartment() {
        return teaDepartment;
    }

    public void setTeaDepartment(String teaDepartment) {
        this.teaDepartment = teaDepartment == null ? null : teaDepartment.trim();
    }

    public String getTeaPhone() {
        return teaPhone;
    }

    public void setTeaPhone(String teaPhone) {
        this.teaPhone = teaPhone == null ? null : teaPhone.trim();
    }

    public String getTeaFlag() {
        return teaFlag;
    }

    public void setTeaFlag(String teaFlag) {
        this.teaFlag = teaFlag == null ? null : teaFlag.trim();
    }

    public String getTeaPassword() {
        return teaPassword;
    }

    public void setTeaPassword(String teaPassword) {
        this.teaPassword = teaPassword == null ? null : teaPassword.trim();
    }

    public String getTeaClass() {
        return teaClass;
    }

    public void setTeaClass(String teaClass) {
        this.teaClass = teaClass == null ? null : teaClass.trim();
    }
}