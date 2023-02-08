package com.liyan;

import com.liyan.config.SpringConfig;
import com.liyan.controller.UserController;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName app
 * @Description TODO
 * @Author name
 * @Date 2023/2/7
 * @Version 1.0
 **/

public class App
{
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        System.out.println(ctx.getBean(UserController.class));
    }
}

