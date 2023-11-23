package com.example.bookstore.domain;

import com.example.bookstore.domain.common.AuditEntity;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
public class Author extends AuditEntity {
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    private String middleName;
    @Past
    private LocalDate birthDate;
    @OneToMany(mappedBy = "author")
    @JsonManagedReference
    private List<Book> books;
}