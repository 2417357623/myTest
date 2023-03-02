package com.example.spring_review;

import com.dao.BookDao;
import com.domain.Book;
import com.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringReviewApplicationTests {

    @Autowired
    private BookService bookService;

    @Autowired
    private BookDao bookDao;

    @Test
    void contextLoads() {
        Book byId = bookService.getById(1000);
        System.out.println(byId);
    }

    @Test
    void testGetById(){
        Book byId = bookDao.getById(1000);
        System.out.println(byId);
    }

}
