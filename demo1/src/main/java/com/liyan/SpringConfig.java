package com.liyan;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;

/**
 * @ClassName SpringConfig
 * @Description TODO
 * @Author name
 * @Date 2023/2/2
 * @Version 1.0
 **/
@Configuration
@ComponentScan("com.liyan")
@PropertySource("Druid.properties")
@Import(JdbcConfig.class)
public class SpringConfig {

}

