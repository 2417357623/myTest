package com.service;

import com.domain.Book;

public interface BookService {
    public void save();

    public Book getById(Integer id);
}
