package com.liyan.dao.impl;

import com.liyan.dao.BookDao;
import org.springframework.stereotype.Repository;

/**
 * @ClassName BookDaoImpl
 * @Description TODO
 * @Author name
 * @Date 2023/2/3
 * @Version 1.0
 **/

@Repository("BookDao")
public class BookDaoImpl implements BookDao {
   private int age;

 public void save() {
  System.out.println("BookDaoImpl save");
     System.out.println(System.currentTimeMillis());
 }

 public void update(){
     System.out.println("BookDaoImpl update");
 }

    public String findName(int id) {
        System.out.println("id:" + id);
        return "itcast";
    }
}

