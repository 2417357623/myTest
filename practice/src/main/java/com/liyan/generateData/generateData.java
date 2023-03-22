package com.liyan.generateData;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.pool.DruidPooledConnection;
import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.person.Person;
import io.codearte.jfairy.producer.person.PersonProperties;

import javax.sql.DataSource;
import java.sql.*;
import java.util.Map;

/**
 * @ClassName generateData
 * @Description TODO
 * @Author name
 * @Date 2023/3/22
 * @Version 1.0
 **/

public class generateData {
    public static void main(String[] args) throws SQLException {
        generateFakeData();
    }

    public static void generateFakeData() throws SQLException {
        String url = "jdbc:mysql://121.36.74.37:3306/mytest";
        String username = "root";
        String password = "123456";
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUsername(username);
        druidDataSource.setPassword(password);
        druidDataSource.setUrl(url);

        DruidPooledConnection conn = null;
        PreparedStatement preparedStatement = null;
        try {
            conn = druidDataSource.getConnection();
            String sql = "insert into mytest.people(NAME, SEX, ADDRESS, EMAIL) VALUES (?,?,?,?)";
            preparedStatement = conn.prepareStatement(sql);
            ;
            for (int i = 0; i < 1000000; i++) {
                Fairy fairy = Fairy.create();
                Person person = fairy.person();

                preparedStatement.setString(1, person.getFullName());
                preparedStatement.setString(2, person.getSex().toString());
                preparedStatement.setString(3, person.getAddress().toString());
                preparedStatement.setString(4, person.getEmail());

//经过测试，并非是fairy生成数据造成插入数据慢
//                preparedStatement.setString(1, "test");
//                preparedStatement.setString(2, "test");
//                preparedStatement.setString(3, "test");
//                preparedStatement.setString(4, "test");

                preparedStatement.executeUpdate();

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            preparedStatement.close();
            conn.close();
        }
    }

}

