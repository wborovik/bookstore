package com.example.bookstore.domain;

import com.example.bookstore.domain.common.AuditEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
public class UserAccount extends AuditEntity {
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    private String middleName;
    @Past
    private LocalDate birthDate;
    @NotBlank
    @Column(unique = true)
    private String login;
    @NotBlank
    private String password;
    @NotEmpty
    @ManyToMany
    @JoinTable(name = "user_account_user_role",
    joinColumns = @JoinColumn(name = "account_id"),
    inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<UserRole> roles;
    @OneToMany
    @JoinTable(name = "user_account_purchased_book",
            joinColumns = @JoinColumn(name = "account_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id"))
    private List<Book> purchasedBooks;
    private boolean isActive = true;
}