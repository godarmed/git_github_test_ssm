package com.leo.util;

import com.leo.entity.Grade;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class StudentsParams {
    //分页条件
    private Integer pageNum;
    private Integer pageSize = 5;

    //条件查询
    private String name;
    private String sex;
    private Byte age;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthdayFrom;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthdayTo;
    private String address;
    private Byte state;
    private Short gid;
    private Grade grade;
    private String orderBy;

    public StudentsParams() {
    }

    public StudentsParams(Integer pageNum, Integer pageSize) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }

    public Short getGid() {
        return gid;
    }

    public void setGid(Short gid) {
        this.gid = gid;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Byte getAge() {
        return age;
    }

    public void setAge(Byte age) {
        this.age = age;
    }

    public Date getBirthdayFrom() {
        return birthdayFrom;
    }

    public void setBirthdayFrom(Date birthdayFrom) {
        this.birthdayFrom = birthdayFrom;
    }

    public Date getBirthdayTo() {
        return birthdayTo;
    }

    public void setBirthdayTo(Date birthdayTo) {
        this.birthdayTo = birthdayTo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "StudentsParams{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", birthdayFrom=" + birthdayFrom +
                ", birthdayTo=" + birthdayTo +
                ", address='" + address + '\'' +
                ", state=" + state +
                ", grade=" + grade +
                '}';
    }
}
