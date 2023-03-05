package com.mybatis.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.annotation.Resource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @ClassName MybatisUtil
 * @Description 工具类
 * @Author Li Yan
 * @Date 2023/3/4 17:27
 * @Version 1.0
 */
public class MybatisUtil {

    private static SqlSessionFactory sqlSessionFactory;

    //构造方法私有化，防止new对象
    private MybatisUtil(){}

    //sqlSessionFactory对象只有一个，所以写在静态代码块，类加载时生成一个就行，对应一个enviroment
    static {
        try {
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static SqlSession openSession() throws IOException {
            return sqlSessionFactory.openSession();
    }
}
