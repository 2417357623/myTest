package com.liyan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName BookController
 * @Description TODO
 * @Author name
 * @Date 2023/2/13
 * @Version 1.0
 **/

@RestController
@RequestMapping("/books")
public class BookController {

    @Value("${lesson}")
    private String lesson;

    @Value("${enterprise.subject[0]}")
    private String subject_00;

    @Autowired
    private Environment environment;

    @GetMapping("/{id}")
    public String getByid(@PathVariable Integer id) {
        System.out.println(subject_00);
        System.out.println(lesson);
        System.out.println(id);
        System.out.println(environment.getProperty("enterprise.age"));
        return "hello spring boot";
    }
}

