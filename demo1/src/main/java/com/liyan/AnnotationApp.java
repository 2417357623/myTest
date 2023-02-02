package com.liyan;

import com.liyan.dao.PersonDao;
import com.liyan.dao.PersonDaoImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName annotationApp
 * @Description TODO
 * @Author name
 * @Date 2023/2/2
 * @Version 1.0
 **/

public class AnnotationApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        PersonDao bean = (PersonDao) ctx.getBean("PersonDao");
        PersonDaoImpl bean1 = (PersonDaoImpl) bean;
        bean1.save();
        System.out.println(bean1);
    }
}

