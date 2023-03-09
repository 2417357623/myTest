package com.jdbctemplate;

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * @ClassName JdbcTest
 * @Description TODO
 * @Author name
 * @Date 2023/3/6
 * @Version 1.0
 **/

public class JdbcTest {

    @Test
    public void test() {
        DruidDataSource dataSource= new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/db1");
        dataSource.setUsername("root");
        dataSource.setPassword("lwto0456");

        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        jdbcTemplate.update("insert into grade values (2,'大二')");


    }
}

