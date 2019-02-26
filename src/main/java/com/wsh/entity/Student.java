package com.wsh.entity;

public class Student {
    private String stuId;

    private String stuName;

    private String stuGrade;

    private String stuDepartment;

    private String stuMajor;

    private String stuClass;

    private String stuPhone;

    private String stuPass;

    private String stuNickname;

    private String stuHeadImg;

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

    public String getStuGrade() {
        return stuGrade;
    }

    public void setStuGrade(String stuGrade) {
        this.stuGrade = stuGrade == null ? null : stuGrade.trim();
    }

    public String getStuDepartment() {
        return stuDepartment;
    }

    public void setStuDepartment(String stuDepartment) {
        this.stuDepartment = stuDepartment == null ? null : stuDepartment.trim();
    }

    public String getStuMajor() {
        return stuMajor;
    }

    public void setStuMajor(String stuMajor) {
        this.stuMajor = stuMajor == null ? null : stuMajor.trim();
    }

    public String getStuClass() {
        return stuClass;
    }

    public void setStuClass(String stuClass) {
        this.stuClass = stuClass == null ? null : stuClass.trim();
    }

    public String getStuPhone() {
        return stuPhone;
    }

    public void setStuPhone(String stuPhone) {
        this.stuPhone = stuPhone == null ? null : stuPhone.trim();
    }

    public String getStuPass() {
        return stuPass;
    }

    public void setStuPass(String stuPass) {
        this.stuPass = stuPass == null ? null : stuPass.trim();
    }

    public String getStuNickname() {
        return stuNickname;
    }

    public void setStuNickname(String stuNickname) {
        this.stuNickname = stuNickname == null ? null : stuNickname.trim();
    }

    public String getStuHeadImg() {
        return stuHeadImg;
    }

    public void setStuHeadImg(String stuHeadImg) {
        this.stuHeadImg = stuHeadImg == null ? null : stuHeadImg.trim();
    }
}