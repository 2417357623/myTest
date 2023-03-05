package com.mybatis.domain;

/**
 * @ClassName Student
 * @Description TODO
 * @Author Li Yan
 * @Date 2023/3/4 17:09
 * @Version 1.0
 */
public class Student {
    private Integer id;
    private String name;
    private Integer value;

    private Integer studentGrade;

    public Student(Integer id, String name, Integer value, Integer studentGrade) {
        this.id = id;
        this.name = name;
        this.value = value;
        this.studentGrade = studentGrade;
    }

    public Integer getStudentGrade() {
        return studentGrade;
    }

    public void setStudentGrade(Integer studentGrade) {
        this.studentGrade = studentGrade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", value=" + value +
                ", studentGrade=" + studentGrade +
                '}';
    }
}
