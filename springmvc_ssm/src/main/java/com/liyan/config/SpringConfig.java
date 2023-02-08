package com.liyan.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/**
 * @ClassName SpringConfig
 * @Description TODO
 * @Author name
 * @Date 2023/2/8
 * @Version 1.0
 **/
@Configuration
@ComponentScan({"com.liyan.service"})
@PropertySource("jdbc.properties")
@Import({JdbcConfig.class, MybatisConfig.class})
public class SpringConfig {
}

