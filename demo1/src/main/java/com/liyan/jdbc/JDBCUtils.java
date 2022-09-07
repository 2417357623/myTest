package com.liyan.jdbc;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {

    /**
     * @description: 获取连接
     * @param:
     * @return:
     * @author Administrator LiYan
     * @date: 2022/9/3 14:48
     */
    public  static Connection jdbcConnection() throws Exception {

        //加载配置文件，并提取配置文件内容
        Properties prop = new Properties();
        prop.load(new FileInputStream("C:\\Users\\Administrator\\Desktop\\demo1\\demo1\\src\\main\\resources\\Druid.properties"));

        String url = prop.getProperty("url");
        String username = prop.getProperty("username");
        String password = prop.getProperty("password");
        String driverClassName = prop.getProperty("driverClassName");

        Class.forName(driverClassName);

        Connection conn = DriverManager.getConnection(url, username, password);

        return conn;
    }

    public  static void jdbcCloseResoure(Connection conn, Statement stmt){
        if(conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if(stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }


    }

    public  static void jdbcCloseResoure(Connection conn, Statement stmt, ResultSet rs){
        if(conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if(stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } if(rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }


    }


}
