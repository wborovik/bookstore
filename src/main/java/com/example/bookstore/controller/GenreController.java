package com.example.bookstore.controller;

import com.example.bookstore.controller.common.AbstractController;
import com.example.bookstore.domain.Genre;
import com.example.bookstore.repository.GenreRepository;
import com.example.bookstore.service.GenreService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("bookstore/genres")
public class GenreController extends AbstractController<Genre, GenreService, GenreRepository> {
    public GenreController(GenreService service) {
        super(service);
    }
}