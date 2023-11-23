package com.example.bookstore.controller;

import com.example.bookstore.controller.common.AbstractController;
import com.example.bookstore.domain.UserAccount;
import com.example.bookstore.repository.UserAccountRepository;
import com.example.bookstore.service.UserAccountService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("bookstore/users")
public class UserAccountController extends AbstractController<UserAccount, UserAccountService, UserAccountRepository> {
    public UserAccountController(UserAccountService service) {
        super(service);
    }
}