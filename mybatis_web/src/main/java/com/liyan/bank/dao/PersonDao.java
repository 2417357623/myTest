package com.liyan.bank.dao;

import com.liyan.bank.pojo.Person;

import java.util.List;

/**
 * @ClassName PersonDao
 * @Description TODO
 * @Author Li Yan
 * @Date 2023/3/6 22:26
 * @Version 1.0
 */
public interface PersonDao {
    public void insert(Person person);
    public void deleteById(int id);
    public void update(Person person);
    public Person selectById(int id);
    public List<Person> selectAll();
}
