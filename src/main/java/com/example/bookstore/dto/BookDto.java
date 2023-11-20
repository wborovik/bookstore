package com.example.bookstore.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class BookDto {
    private String title;
    private String isbn;
    private Long genreId;
    private Long AuthorId;
    private BigDecimal price;
    private String currency;
    private int realizationCount;
}
