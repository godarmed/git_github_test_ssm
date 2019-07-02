package com.leo.entity;

import java.util.List;
import java.util.Objects;

public class Grade implements Comparable<Grade>{
    private Short gid;

    private String gname;

    private List<Students> students;

    public List<Students> getStudents() {
        return students;
    }

    public void setStudents(List<Students> students) {
        this.students = students;
    }

    public Short getGid() {
        return gid;
    }

    public void setGid(Short gid) {
        this.gid = gid;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname == null ? null : gname.trim();
    }

    @Override
    public String toString() {
        return "Grade{" +
                "gid=" + gid +
                ", gname='" + gname + '\'' +
                ", students=" + students +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (o == null || getClass() != o.getClass()) {return false;}
        Grade grade = (Grade) o;
        return gname.equals(grade.gname);
    }

    @Override
    public int hashCode() {
        return this.gname.hashCode();
    }

    @Override
    public int compareTo(Grade o) {
        return this.hashCode() - o.hashCode();
    }
}