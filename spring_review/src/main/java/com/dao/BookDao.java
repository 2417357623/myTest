package com.dao;

import com.domain.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @ClassName BookDao
 * @Description TODO
 * @Author name
 * @Date 2023/3/2
 * @Version 1.0
 **/

// TODO 添加@Mapper
@Mapper
public interface BookDao {
    @Select("select * from school.student where studentNo = #{id}")
    public Book getById(Integer id);
}

