package com.example.bookstore.service;

import com.example.bookstore.domain.Author;
import com.example.bookstore.repository.AuthorRepository;
import com.example.bookstore.service.common.AbstractService;
import org.springframework.stereotype.Service;

@Service
public class AuthorService extends AbstractService<Author, AuthorRepository> {
    public AuthorService(AuthorRepository repository) {
        super(repository);
    }
}