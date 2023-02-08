package com.liyan;

import com.liyan.config.SpringConfig;
import com.liyan.dao.BookDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName app
 * @Description TODO
 * @Author name
 * @Date 2023/2/3
 * @Version 1.0
 **/

public class app {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        BookDao bookDao = (BookDao) ctx.getBean(BookDao.class);
        String name = bookDao.findName(100);
        System.out.println(name);
    }
}

