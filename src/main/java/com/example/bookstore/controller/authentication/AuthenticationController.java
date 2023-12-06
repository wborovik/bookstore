package com.example.bookstore.controller.authentication;

import com.example.bookstore.dto.RegistrationUserDto;
import com.example.bookstore.dto.UserAccountDto;
import com.example.bookstore.dto.jwt.JwtRequest;
import com.example.bookstore.dto.jwt.JwtResponse;
import com.example.bookstore.service.authentication.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthenticationController {
   private final AuthenticationService authenticationService;

    @PostMapping("auth")
    public JwtResponse createAuthToken(@RequestBody JwtRequest authRequest) {
        return authenticationService.createAuthToken(authRequest);
    }

    @PostMapping("registration")
    public UserAccountDto createNewUser(@RequestBody RegistrationUserDto userDto) {
        return authenticationService.createNewUser(userDto);
    }
}