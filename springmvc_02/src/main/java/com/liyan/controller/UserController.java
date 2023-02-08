package com.liyan.controller;

import com.liyan.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author name
 * @Date 2023/2/6
 * @Version 1.0
 **/
@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/save")
    @ResponseBody
    public String save(){
        System.out.println("user..save");
        return "{'module':'springmvc'}";
    }

    @ResponseBody
    @RequestMapping("/commonparam")
    public String commonParam(String name,int age){
        System.out.println("普通参数传递：" + "name:" + name + "/n"+ "age:" + age);
        return "succeed";
    }

    @ResponseBody
    @RequestMapping("/pojoparam")
    public String pojoParam( @RequestParam List<String> likes){
        System.out.println(likes);
        return "succeed";
    }

    @RequestMapping("/listParamForJson")
    @ResponseBody
    public String listParamForJson(@RequestBody List<String> likes){
        System.out.println(likes);
        return "succeed";
    }

    @RequestMapping("/pojoParamForJson")
    @ResponseBody
    public String pojoParamForJson(@RequestBody User user){
        System.out.println(user);
        return "succeed";
    }
}

