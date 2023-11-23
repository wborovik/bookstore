package com.example.bookstore.service.authentication;

import com.example.bookstore.domain.UserAccount;
import com.example.bookstore.dto.RegistrationUserDto;
import com.example.bookstore.dto.jwt.JwtRequest;
import com.example.bookstore.dto.jwt.JwtResponse;
import com.example.bookstore.exception.ApplicationError;
import com.example.bookstore.mapper.UserAccountMapper;
import com.example.bookstore.service.UserAccountService;
import com.example.bookstore.util.JwtTokenUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserAccountService userAccountService;
    private final JwtTokenUtils jwtTokenUtils;
    private final AuthenticationManager authenticationManager;
    private final UserAccountMapper userAccountMapper;

    public ResponseEntity<?> createAuthToken(@RequestBody JwtRequest authRequest) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        } catch (BadCredentialsException ex) {
            return new ResponseEntity<>(new ApplicationError(HttpStatus.UNAUTHORIZED.value(),
                    "incorrect login or password"), HttpStatus.UNAUTHORIZED);
        }
        UserDetails userDetails = userAccountService.loadUserByUsername(authRequest.getUsername());
        String token = jwtTokenUtils.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    public ResponseEntity<?> createNewUser(@RequestBody RegistrationUserDto userDto) throws Exception {
        if (!userDto.getPassword().equals(userDto.getConfirmPassword())) {
            return new ResponseEntity<>(new ApplicationError(HttpStatus.BAD_REQUEST.value(),
                    "Passwords don't match"), HttpStatus.BAD_REQUEST);
        }
        try {
            userAccountService.findUserByLogin(userDto.getLogin());
        } catch (UsernameNotFoundException ex) {
            UserAccount user = userAccountService.registerNewUser(userDto);
            return ResponseEntity.ok(userAccountMapper.userAccountToUserAccountDto(user));
        }
        return new ResponseEntity<>(new ApplicationError(HttpStatus.BAD_REQUEST.value(),
                "A user with this login already exists"), HttpStatus.BAD_REQUEST);
    }
}