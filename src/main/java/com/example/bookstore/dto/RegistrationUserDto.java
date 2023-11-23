package com.example.bookstore.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class RegistrationUserDto {
    private String firstName;
    private String lastName;
    private String middleName;
    private LocalDate birthDate;
    private String login;
    private String password;
    private String confirmPassword;
}
