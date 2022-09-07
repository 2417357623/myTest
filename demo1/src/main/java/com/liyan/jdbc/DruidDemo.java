package com.liyan.jdbc;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

public class DruidDemo {
    public static void main(String[] args) throws Exception {
        //导包

        //定义配置文件

        //加载配置文件

        Properties prop = new Properties();
        prop.load(new FileInputStream("C:\\Users\\Administrator\\Desktop\\demo1\\demo1\\src\\main\\resources\\Druid.properties"));

        //获取连接池对象

        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

        //获取数据库连接
        Connection conn = dataSource.getConnection();

        System.out.println(conn);

    }
}
