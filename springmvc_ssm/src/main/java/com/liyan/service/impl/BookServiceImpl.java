package com.liyan.service.impl;

import com.liyan.controller.Code;
import com.liyan.dao.BookDao;
import com.liyan.domain.Book;
import com.liyan.exception.BusinessException;
import com.liyan.exception.SystemException;
import com.liyan.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName BookServiceImpl
 * @Description TODO
 * @Author name
 * @Date 2023/2/8
 * @Version 1.0
 **/
@Service
public class BookServiceImpl implements BookService {

    //这里没有创建bookDao的bean因为mybatis做了自动代理，自动创建了bean
    @Autowired
    private BookDao bookDao;

    public boolean save(Book book) {
        bookDao.save(book);
        return true;
    }

    public boolean delete(Integer id) {
        bookDao.delete(id);
        return true;
    }

    public boolean update(Book book) {
        bookDao.update(book);
        return true;
    }

    public Book getById(Integer id) {

        if(id==0){
            throw new BusinessException("输入参数有误", Code.BUSINESS_ERR);
        }

        try{
            int i = 1/0;
        }catch (Exception e){
            throw new SystemException("服务器访问超时",e,Code.SYSTEM_TIMEOUT_ERR);
        }

        return bookDao.getById(id);
    }

    public List<Book> getAll() {
        return bookDao.getAll();
    }
}

