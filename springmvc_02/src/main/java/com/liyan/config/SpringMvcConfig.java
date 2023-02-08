package com.liyan.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @ClassName SpringMvcConfig
 * @Description TODO
 * @Author name
 * @Date 2023/2/6
 * @Version 1.0
 **/
@Configuration
@ComponentScan("com.liyan.controller")
@EnableWebMvc
public class SpringMvcConfig {

}

