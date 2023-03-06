package com.liyan.bank.pojo;

/**
 * @ClassName Person
 * @Description TODO
 * @Author Li Yan
 * @Date 2023/3/6 22:24
 * @Version 1.0
 */
public class Person {
    private String name;
    private String homePosition;

    private int id;

    public Person() {
    }

    public Person(int id,String name, String homePosition) {
        this.name = name;
        this.homePosition = homePosition;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHomePosition() {
        return homePosition;
    }

    public void setHomePosition(String homePosition) {
        this.homePosition = homePosition;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", homePosition='" + homePosition + '\'' +
                ", id=" + id +
                '}';
    }
}
