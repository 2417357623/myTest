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
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName generateData
 * @Description TODO
 * @Author name
 * @Date 2023/3/22
 * @Version 1.0
 **/

public class generateData {
    public static void main(String[] args) throws SQLException {
        //毫秒ms：
        long startTime=System.currentTimeMillis(); //获取开始时间

        //要测的程序或方法
        generateFakeData_2();

        long endTime=System.currentTimeMillis(); //获取结束时间
        System.out.println("程序运行时间： "+(endTime-startTime)+"ms");

        //最后一句函数输出时间和提示程序结束不一致，
        // 那么可能是因为您在与数据库交互时使用了异步方法或非阻塞IO操作。
        // 这些操作不会阻塞程序的主线程，而是在后台线程中进行。因此，程序可能会在主线程中完成并退出，而后台线程仍在继续运行。
        //为了解决这个问题，您可以使用Java的异步编程机制来确保程序等待数据库操作完成后再退出。

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
            conn.setAutoCommit(false);
            String sql = "insert into mytest.people(NAME, SEX, ADDRESS, EMAIL) VALUES (?,?,?,?)";
            preparedStatement = conn.prepareStatement(sql);

            for (int j = 0; j<1000; j++) {
                for (int i = 0; i < 1000; i++) {
                    Fairy fairy = Fairy.create();
                    Person person = fairy.person();
    
                    preparedStatement.setString(1, person.getFullName());
                    preparedStatement.setString(2, person.getSex().toString());
                    preparedStatement.setString(3, person.getAddress().toString());
                    preparedStatement.setString(4, person.getEmail());
                    preparedStatement.addBatch();
    
    //经过测试，并非是fairy生成数据造成插入数据慢
    //                preparedStatement.setString(1, "test");
    //                preparedStatement.setString(2, "test");
    //                preparedStatement.setString(3, "test");
    //                preparedStatement.setString(4, "test");
    
    
    
                }
                preparedStatement.executeBatch();
                conn.commit();
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            preparedStatement.close();
            conn.close();
        }
    }

    //多线程，
    public static void generateFakeData_2() throws SQLException {
        String url = "jdbc:mysql://121.36.74.37:3306/mytest";
        String username = "root";
        String password = "123456";
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUsername(username);
        druidDataSource.setPassword(password);
        druidDataSource.setUrl(url);

        int batchSize = 100; // Set batch size to 10000
        int threadCount = 4; // Set number of threads to 4

        ExecutorService executorService = Executors.newFixedThreadPool(threadCount);

        DruidPooledConnection conn = null;
        try {
            conn = druidDataSource.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO mytest.people (NAME, SEX, ADDRESS, EMAIL) VALUES (?, ?, ?, ?)");

            conn.setAutoCommit(false);

            for (int j = 0; j < threadCount; j++) {
                DruidPooledConnection finalConn = conn;
                executorService.execute(() -> {
                    try {
                        for (int t = 0; t < 1; t++) {
                            for (int i = 0; i < batchSize; i++) {
                                Fairy fairy = Fairy.create();
                                Person person = fairy.person();

                                preparedStatement.setString(1, person.getFullName());
                                preparedStatement.setString(2, person.getSex().toString());
                                preparedStatement.setString(3, person.getAddress().toString());
                                preparedStatement.setString(4, person.getEmail());
                                preparedStatement.addBatch();

                                if ((i + 1) % batchSize == 0) {
                                    preparedStatement.executeBatch();
                                    finalConn.commit();
                                }
                            }

                            // Execute any remaining batches
                            preparedStatement.executeBatch();
                            finalConn.commit();
                        }
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                });
            }
        } finally {
            executorService.shutdown();
            conn.close();
        }


    }

}

