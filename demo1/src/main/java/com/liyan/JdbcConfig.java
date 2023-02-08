package com.liyan;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

/**
 * @ClassName JdbcConfig
 * @Description TODO
 * @Author name
 * @Date 2023/2/3
 * @Version 1.0
 **/

public class JdbcConfig {
    //管理第三方bean，由于不能把@value这类的写在他们源代码中，所以必须我们自己写bean
    //定义一个方法获得要管理的对象,加上@bean，表示返回值是个第三方的bean
    @Bean
    public DataSource dataSource() {
        DruidDataSource ds = new DruidDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql:///db1jdbc:mysql:///db1");
        ds.setUsername("root");
        ds.setPassword("lwto0456");
        return ds;
    }
}

