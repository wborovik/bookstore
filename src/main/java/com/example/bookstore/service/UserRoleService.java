package com.example.bookstore.service;

import com.example.bookstore.domain.UserRole;
import com.example.bookstore.repository.UserRoleRepository;
import com.example.bookstore.service.common.AbstractService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class UserRoleService extends AbstractService<UserRole, UserRoleRepository> {
    public UserRoleService(UserRoleRepository repository) {
        super(repository);
    }

    public UserRole findUserRoleByRoleName(String roleName) throws EntityNotFoundException {
        return repository.findUserRoleByRoleName(roleName).orElseThrow(() ->
                new EntityNotFoundException(String.format("Role %s not found", roleName)));
    }
}