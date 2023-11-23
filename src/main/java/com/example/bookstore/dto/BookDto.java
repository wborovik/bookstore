package com.example.bookstore.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class BookDto {
    private String title;
    private String isbn;
    private Long genreId;
    private Long AuthorId;
    private BigDecimal price;
    private String currency;
    private int realizationCount;
}
