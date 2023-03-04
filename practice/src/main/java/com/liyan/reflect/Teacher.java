package com.liyan.reflect;

public class Teacher {
    private int age;
    private String name;
    private String subject;

    public Teacher(int age, String name, String subject) {
        this.age = age;
        this.name = name;
        this.subject = subject;
    }

    public void teach(){
        System.out.println("teach");

    }

    @Override
    public String toString() {
        return "Teacher{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", subject='" + subject + '\'' +
                '}';
    }
}
