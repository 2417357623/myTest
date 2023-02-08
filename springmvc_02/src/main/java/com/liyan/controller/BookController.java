package com.liyan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName BookController
 * @Description TODO
 * @Author name
 * @Date 2023/2/7
 * @Version 1.0
 **/
@Controller
@RequestMapping("/book")
public class BookController {
    @ResponseBody
    @RequestMapping("/save")
    public String save() {
        System.out.println("book..save");
        return "{'module':'springmvc'}";
    }


}

