package com.liyan.service;

import com.liyan.dao.PersonDao;
import com.liyan.dao.PersonDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @ClassName PersonService
 * @Description TODO
 * @Author name
 * @Date 2022/9/29
 * @Version 1.0
 **/

@Service("PersonService")
public class PersonService {

    @Autowired
    @Qualifier("PersonDao2")
    private PersonDao personDao;
    @Value("111")
    private int age;
    @Value("${url}")
    private String url;

    public void save(){
        System.out.println(" service save");
        personDao.save();
        System.out.println(age);
        System.out.println(url);
    }

}

