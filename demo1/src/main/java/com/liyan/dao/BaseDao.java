package com.liyan.dao;

import com.liyan.bean.Person;
import com.liyan.jdbc.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



public class BaseDao {

    /**
     * @description: JDBC查询
     * @param:
     * @return:
     * @author Administrator LiYan
     * @date: 2022/9/3 18:34
     */
    public Person queryoneid() throws Exception {
        Person person = new Person();
        Connection conn = JDBCUtils.jdbcConnection();
        String sql = "select * from persons";
        PreparedStatement pstmt = conn.prepareStatement(sql);

        ResultSet rs = pstmt.executeQuery();

        if (rs.next()){
            int PersonID = rs.getInt(1);
            String Lastname = rs.getString(2);
            String FirstName = rs.getString(3);
            String Address = rs.getString(4);
            String City = rs.getString(5);
            person = new Person(PersonID,Lastname,FirstName,Address,City);


        }

        JDBCUtils.jdbcCloseResoure(conn,pstmt,rs);
        return person;

    }

    public void update(Connection conn ,String sql , Object ...objects) throws Exception {


        PreparedStatement pstmt = conn.prepareStatement(sql);

        for(int i = 0; i <  objects.length; i++){
            pstmt.setObject(i+1,objects[i]);

        }

        pstmt.execute();

        JDBCUtils.jdbcCloseResoure(null,pstmt);

    }

}
