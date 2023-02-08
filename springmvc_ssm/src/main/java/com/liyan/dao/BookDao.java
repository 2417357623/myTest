package com.liyan.dao;

import com.liyan.domain.Book;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BookDao {

    @Insert("insert into tb_book (name, type, description) values (#{name},#{type},#{description});")
    public void save(Book book);

    public void delete(Integer id);

    public void update(Book book);

    @Select("select * from tb_book where id = #{id}")
    public Book getById(Integer id);

    @Select("select * from tb_book")
    public List<Book> getAll();
}
