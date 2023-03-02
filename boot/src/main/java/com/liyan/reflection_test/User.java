package com.liyan.reflection_test;

import com.liyan.annotation_test.Table;

/**
 * @ClassName User
 * @Description TODO
 * @Author name
 * @Date 2023/2/7
 * @Version 1.0
 **/

@Table("注解")
public class User extends UserFather{

    static {
        System.out.println("子类被加载");
        m = 300;
    }

    static int m = 100;
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void save(){
        System.out.println("save");
    };

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

