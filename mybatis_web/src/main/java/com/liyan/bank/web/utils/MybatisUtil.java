package com.liyan.bank.web.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

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

    public static ThreadLocal<SqlSession> local = new ThreadLocal<SqlSession>();


    public static SqlSession openSession() {
        SqlSession sqlSession = local.get();
        if(sqlSession == null){
            sqlSession = sqlSessionFactory.openSession();
            local.set(sqlSession);
        }
        return sqlSession;
    }

    public static void close(SqlSession sqlSession){
        if(sqlSession != null){
            sqlSession.close();
            local.remove();

        }
    }
}
