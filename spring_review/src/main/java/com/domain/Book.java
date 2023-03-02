package com.domain;

/**
 * @ClassName Book
 * @Description TODO
 * @Author name
 * @Date 2023/3/2
 * @Version 1.0
 **/

public class Book {
    private int studentNo;

    private String studentName;

    @Override
    public String toString() {
        return "Book{" +
                "studentNo=" + studentNo +
                ", studentName='" + studentName + '\'' +
                '}';
    }
}

