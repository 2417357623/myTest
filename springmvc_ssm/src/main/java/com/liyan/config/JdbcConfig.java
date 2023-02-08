package com.liyan.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

/**
 * @ClassName JdbcConfig
 * @Description TODO
 * @Author name
 * @Date 2023/2/8
 * @Version 1.0
 **/

public class JdbcConfig {
    //用value是为了不提前给属性赋值
    @Value("${jdbc.driver}")
    private String driver;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;
    @Value("${jdbc.url}")
    private String url;

    @Bean
    public DataSource dataSource() {
        DruidDataSource ds = new DruidDataSource();
        ds.setDriverClassName(driver);
        ds.setPassword(password);
        ds.setUsername(username);
        ds.setUrl(url);
        return ds;
    }
}

