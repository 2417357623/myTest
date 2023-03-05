package com.mybatis;

import com.mybatis.domain.Student;
import com.mybatis.util.MybatisUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import sun.misc.Resource;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName MybatisTest
 * @Description TODO
 * @Author Li Yan
 * @Date 2023/3/5 2:04
 * @Version 1.0
 */
public class MybatisTest {

    @Test
    public void testInsertStudent(){
        SqlSession sqlSession = null;
        try {
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

            //        String property = System.getProperty("user.dir");
            //        System.out.println(property);
//        InputStream is = new FileInputStream("practice/src/main/resources/mybatis-config.xml");

            //这种方法好，通过类路径来获取配置资源
            InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
            //openSession 里面 早了conn,并且调用conn的相关事务的操作，和conn造sql执行对象的方法
            sqlSession = sqlSessionFactory.openSession();
            int count = sqlSession.insert("insertStudent");
            System.out.println("插入" + count + "条记录");

            //手动提交事务，底层执行conn.commit()
            sqlSession.commit();
        } catch (Exception e) {
            if (sqlSession != null) {
                sqlSession.rollback();
            }
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testByUtil() throws IOException {

        SqlSession sqlSession = MybatisUtil.openSession();

//        HashMap<String, Object> map = new HashMap<>();
//        map.put("id",1);
//        map.put("name","lili");
//        map.put("value",1);
//        sqlSession.insert("insertStudent",map);
        Student student = new Student(3,"lili2",111,4);
        sqlSession.insert("insertStudent",student);
        sqlSession.delete("deleteById",3);
        Object o = sqlSession.selectOne("selectById", 2);
        System.out.println(o);
        sqlSession.commit();

    }

    @Test
    public void configurationTest() throws IOException {
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory test = sqlSessionFactoryBuilder.build(Resources.getResourceAsStream("mybatis-config.xml"), "test");
        SqlSession sqlSession = test.openSession();
        sqlSession.insert("insertStudent",new Student(1,"lili2",111,4));
        sqlSession.commit();
    }


}
