package com.example.bookstore.exception;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ApplicationError {
    private int status;
    private String message;
    private LocalDateTime timeStamp;

    public ApplicationError(int status, String message) {
        this.status = status;
        this.message = message;
        this.timeStamp = LocalDateTime.now();
    }
}