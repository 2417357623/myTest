package com.liyan.bank.dao;

import com.liyan.bank.pojo.Person;
import org.apache.ibatis.annotations.Param;

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
    public void deleteById(Integer id);
    public void update(Person person);
    public Person selectById(Integer id);
    public List<Person> selectAll();

    public List<Person> selectByMultiCondition(@Param("name") String name,@Param("homePosition")String homePosition,@Param("id")int id);

    public void updateBySet(Person person);

    public void deleteByIds(int[] ids);

    public void insertBatch(@Param("persons") List<Person> persons);

    public List<Person> selectAllByResultMap();
}
