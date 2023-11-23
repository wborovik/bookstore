package com.example.bookstore.service.authentication;

import com.example.bookstore.domain.UserAccount;
import com.example.bookstore.dto.RegistrationUserDto;
import com.example.bookstore.dto.UserAccountDto;
import com.example.bookstore.dto.jwt.JwtRequest;
import com.example.bookstore.dto.jwt.JwtResponse;
import com.example.bookstore.exception.EntityAlreadyExistsException;
import com.example.bookstore.exception.PasswordsNotMatchException;
import com.example.bookstore.mapper.UserAccountMapper;
import com.example.bookstore.service.UserAccountService;
import com.example.bookstore.util.JwtTokenUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
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

    public JwtResponse createAuthToken(@RequestBody JwtRequest authRequest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(),
                authRequest.getPassword()));
        UserDetails userDetails = userAccountService.loadUserByUsername(authRequest.getUsername());
        String token = jwtTokenUtils.generateToken(userDetails);

        return new JwtResponse(token);
    }

    public UserAccountDto createNewUser(@RequestBody RegistrationUserDto userDto) {
        if (!userDto.getPassword().equals(userDto.getConfirmPassword())) {
            throw new PasswordsNotMatchException("Passwords don't match");
        }
        try {
            userAccountService.findUserByLogin(userDto.getLogin());
        } catch (UsernameNotFoundException ex) {
            UserAccount user = userAccountService.registerNewUser(userDto);

            return userAccountMapper.userAccountToUserAccountDto(user);
        }
        throw new EntityAlreadyExistsException(String.format("A user with login '%s' already exists", userDto.getLogin()));
    }
}