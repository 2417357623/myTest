package com.service.impl;

import com.dao.BookDao;
import com.domain.Book;
import com.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @ClassName bookServiceImpl
 * @Description TODO
 * @Author name
 * @Date 2023/3/2
 * @Version 1.0
 **/
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Value("1000")
    private int id;

    @Override
    public void save() {
        System.out.println("save");
    }


    @Override
    public Book getById(Integer id) {
        Book byId = bookDao.getById(id);
        return byId;
    }
}

