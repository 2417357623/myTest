package com.liyan.dao;

import com.liyan.bean.Person;
import org.springframework.stereotype.Repository;

import java.sql.Connection;

@Repository("PersonDao2")
public class PersonDaoImpl2 extends BaseDao implements PersonDao{

    @Override
    public void insert(Connection conn, Person person) {
       String sql = "insert into persons (LastName,Address) values(?,?)";

        try {
            update(conn,sql,person.getLastName(),person.getAddress());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Person query() {
        return null;
    }

    @Override
    public void delectById(Connection conn, int id) {

    }

    @Override
    public void update(Connection conn, Person person) {

    }
    public void save(){
        System.out.println(" dao save2 ");
    }
}
