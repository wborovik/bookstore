package com.example.bookstore.dto;

import com.example.bookstore.domain.UserRole;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class UserAccountDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String middleName;
    private LocalDate birthDate;
    private List<UserRole> roles;
    private boolean isActive = true;
}