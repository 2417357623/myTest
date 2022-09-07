package com.liyan.dao;

import com.liyan.bean.Person;

import java.sql.Connection;

public interface PersonDao {

    /**
     * @description: 将person对象传到数据库中
     * @param:
     * @return:
     * @author Administrator LiYan
     * @date: 2022/9/3 21:44
     */
    public abstract void insert(Connection conn, Person person);


    Person query();

    void delectById(Connection conn, int id);

    void   update(Connection conn, Person person);

}
