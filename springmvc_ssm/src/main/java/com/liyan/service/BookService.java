package com.liyan.service;

import com.liyan.dao.BookDao;
import com.liyan.domain.Book;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BookService {


    /*/**
             * 功能: 新增保存
             * 作者: 李炎
             * 关键逻辑:
             * @param [book]
             * @return boolean
             */
    public boolean save(Book book);

    public boolean delete(Integer id);

    public boolean update(Book book);

    public Book getById(Integer id);

    public List<Book> getAll();
}
