package com.liyan.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName SpringConfig
 * @Description TODO
 * @Author name
 * @Date 2023/2/7
 * @Version 1.0
 **/
@Configuration
@ComponentScan({"com.liyan.service","com.liyan.dao"})
public class SpringConfig {
}

