package com.liyan.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo {
    public static void main(String[] args) throws Exception {

//        Class.forName("com.mysql.jdbc.Driver");
//
//        String url = "jdbc:mysql://localhost:3306/db1";
//        String username = "root";
//        String password = "lwto0456";
//        Connection conn = DriverManager.getConnection(url,username,password);

        Connection conn = JDBCUtils.jdbcConnection();

        String sql2 = "update persons set lastname = 'li' where personID = 1";

        Statement stmt= conn.createStatement();

        try {
            conn.setAutoCommit(false);
            int count2 = stmt.executeUpdate(sql2);

            System.out.println(count2);

            conn.commit();
        } catch (Exception e) {
            conn.rollback();
            throw new RuntimeException(e);
        }

        stmt.close();
        conn.close();

    }
}
