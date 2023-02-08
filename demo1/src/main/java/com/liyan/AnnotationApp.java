package com.liyan;

import com.liyan.dao.PersonDao;
import com.liyan.dao.PersonDaoImpl;
import com.liyan.service.PersonService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;

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
        PersonService bean = (PersonService) ctx.getBean("PersonService");
        bean.save();
        System.out.println(bean);
        DataSource bean1 = ctx.getBean(DataSource.class);
        System.out.println(bean1);
    }
}

