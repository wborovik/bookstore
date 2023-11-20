package com.example.bookstore.service;

import com.example.bookstore.domain.Book;
import com.example.bookstore.repository.BookRepository;
import com.example.bookstore.service.common.AbstractService;
import org.springframework.stereotype.Service;

@Service
public class BookService extends AbstractService<Book, BookRepository> {
    public BookService(BookRepository repository) {
        super(repository);
    }
}