package com.liyan.bank.pojo;

/**
 * @ClassName Student
 * @Description TODO
 * @Author name
 * @Date 2023/3/9
 * @Version 1.0
 **/

public class Student {
    private Integer sid;
    private String sname;

    private Clazz clazz;

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", clazz=" + clazz +
                '}';
    }
}

