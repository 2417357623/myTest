package com.liyan;

import com.liyan.dao.PersonDao;
import com.liyan.dao.PersonDaoImpl;
import com.liyan.service.PersonService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName app
 * @Description TODO
 * @Author name
 * @Date 2022/9/29
 * @Version 1.0
 **/

public class app {
    public static void main(String[] args) {
        //获取ioc容器
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取bean
        PersonDaoImpl personDao = (PersonDaoImpl) ctx.getBean("personDao");
        personDao.save();

        PersonService personService = (PersonService) ctx.getBean("personService");
        personService.save();
    }
}

