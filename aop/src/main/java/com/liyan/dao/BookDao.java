package com.liyan.dao;

public interface BookDao {
    public void save();
    public void update();

    public String findName(int id);
}