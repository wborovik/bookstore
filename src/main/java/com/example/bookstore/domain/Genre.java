package com.example.bookstore.domain;

import com.example.bookstore.domain.common.AuditEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Entity
public class Genre extends AuditEntity {
    @NotBlank
    private String description;
}