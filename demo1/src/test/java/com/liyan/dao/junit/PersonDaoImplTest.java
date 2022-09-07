package com.liyan.dao.junit;

import com.liyan.bean.Person;
import com.liyan.dao.PersonDaoImpl;
import com.liyan.jdbc.JDBCUtils;
import org.junit.jupiter.api.Test;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.*;

class PersonDaoImplTest {

    PersonDaoImpl dao = new PersonDaoImpl();
    @Test
    void insert() throws Exception {
        Connection conn = JDBCUtils.jdbcConnection();
        Person person = new Person(2, "li", "yan", "aa", "bb");
        dao.insert(conn,person);
        JDBCUtils.jdbcCloseResoure(conn,null);
    }

    @Test
    void query() throws Exception {
        Connection conn = JDBCUtils.jdbcConnection();
        JDBCUtils.jdbcCloseResoure(conn,null);
    }

    @Test
    void delectById() throws Exception {
        Connection conn = JDBCUtils.jdbcConnection();
        JDBCUtils.jdbcCloseResoure(conn,null);
    }

    @Test
    void update() throws Exception {
        Connection conn = JDBCUtils.jdbcConnection();
        JDBCUtils.jdbcCloseResoure(conn,null);
    }
}