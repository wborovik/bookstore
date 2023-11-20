package com.example.bookstore.service;

import com.example.bookstore.domain.UserRole;
import com.example.bookstore.repository.UserRoleRepository;
import com.example.bookstore.service.common.AbstractService;
import org.springframework.stereotype.Service;

@Service
public class UserRoleService extends AbstractService<UserRole, UserRoleRepository> {
    public UserRoleService(UserRoleRepository repository) {
        super(repository);
    }

    public UserRole findUserRoleByRoleName(String roleName) throws Exception {
        return repository.findUserRoleByRoleName(roleName).orElseThrow(Exception::new);
    }
}