package com.liyan.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @ClassName SpringConfig
 * @Description TODO
 * @Author name
 * @Date 2023/2/3
 * @Version 1.0
 **/
@Configuration
@ComponentScan("com.liyan")
@EnableAspectJAutoProxy
public class SpringConfig {
}

