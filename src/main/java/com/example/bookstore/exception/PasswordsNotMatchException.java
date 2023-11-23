package com.example.bookstore.exception;

public class PasswordsNotMatchException extends RuntimeException {
    public PasswordsNotMatchException(String message) {
        super(message);
    }
}