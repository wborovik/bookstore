package com.example.bookstore.controller;

import com.example.bookstore.controller.common.AbstractController;
import com.example.bookstore.domain.Book;
import com.example.bookstore.repository.BookRepository;
import com.example.bookstore.service.BookService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("book")
public class BookController extends AbstractController<Book, BookService, BookRepository> {
    public BookController(BookService service) {
        super(service);
    }
}