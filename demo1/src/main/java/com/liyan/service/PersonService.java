package com.liyan.service;

import com.liyan.dao.PersonDao;
import com.liyan.dao.PersonDaoImpl;

/**
 * @ClassName PersonService
 * @Description TODO
 * @Author name
 * @Date 2022/9/29
 * @Version 1.0
 **/

public class PersonService {

    private PersonDao personDao;

    public void save(){
        System.out.println(" service save");
        PersonDaoImpl PersonDaoImpl = (PersonDaoImpl)personDao;
        PersonDaoImpl.save();
    }

    public void setPersonDao(PersonDao personDao) {
        this.personDao = personDao;
    }
}

