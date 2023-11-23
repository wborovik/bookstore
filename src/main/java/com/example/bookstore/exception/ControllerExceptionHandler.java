package com.example.bookstore.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;

@Slf4j
@RestControllerAdvice
public class ControllerExceptionHandler {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({EntityNotFoundException.class, UsernameNotFoundException.class})
    public ErrorMessage entityNotFoundException(Exception ex) {
        log.error(String.format("Error: %s", ex.getMessage()), ex);
        return getMessageError(ex, HttpStatus.NOT_FOUND);
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(BadCredentialsException.class)
    public ErrorMessage badCredentialsException(BadCredentialsException ex) {
        log.error("Error: incorrect login or password", ex);
        return getMessageError(ex, HttpStatus.UNAUTHORIZED);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({PasswordsNotMatchException.class, EntityAlreadyExistsException.class})
    public ErrorMessage passwordsNotMatchException(Exception ex) {
        log.error(String.format("Error: %s", ex.getMessage()), ex);
        return getMessageError(ex, HttpStatus.BAD_REQUEST);
    }

    private ErrorMessage getMessageError(Exception ex, HttpStatus status) {
        ErrorMessage message = new ErrorMessage();
        message.setTimeStamp(LocalDateTime.now());
        message.setStatus(status.value());
        message.setMessage(ex.getMessage());

        return message;
    }
}