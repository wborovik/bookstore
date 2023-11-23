package com.example.bookstore.controller;

import com.example.bookstore.controller.common.AbstractController;
import com.example.bookstore.domain.Author;
import com.example.bookstore.repository.AuthorRepository;
import com.example.bookstore.service.AuthorService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("bookstore/authors")
public class AuthorController extends AbstractController<Author, AuthorService, AuthorRepository> {
    public AuthorController(AuthorService service) {
        super(service);
    }
}
