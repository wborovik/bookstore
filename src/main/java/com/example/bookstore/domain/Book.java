package com.example.bookstore.domain;

import com.example.bookstore.domain.common.AuditEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.ISBN;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
public class Book extends AuditEntity {
    private String title;
    @ISBN
    @NotBlank
    @Column(unique = true)
    private String isbn;
    @ManyToOne
    private Genre genre;
    @ManyToOne
    private Author author;
    @NotNull
    private BigDecimal price;
    @NotBlank
    private String currency;
    private int realizationCount;
}