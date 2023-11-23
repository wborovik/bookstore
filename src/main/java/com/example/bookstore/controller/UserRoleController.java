package com.example.bookstore.controller;

import com.example.bookstore.controller.common.AbstractController;
import com.example.bookstore.domain.UserRole;
import com.example.bookstore.repository.UserRoleRepository;
import com.example.bookstore.service.UserRoleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("bookstore/roles")
public class UserRoleController extends AbstractController<UserRole, UserRoleService, UserRoleRepository> {
    public UserRoleController(UserRoleService service) {
        super(service);
    }
}