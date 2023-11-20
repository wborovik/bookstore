package com.example.bookstore.service;

import com.example.bookstore.domain.Genre;
import com.example.bookstore.repository.GenreRepository;
import com.example.bookstore.service.common.AbstractService;
import org.springframework.stereotype.Service;

@Service
public class GenreService extends AbstractService<Genre, GenreRepository> {
    public GenreService(GenreRepository repository) {
        super(repository);
    }
}