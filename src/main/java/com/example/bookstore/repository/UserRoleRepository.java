package com.example.bookstore.repository;

import com.example.bookstore.domain.UserRole;
import com.example.bookstore.repository.common.AbstractRepository;

import java.util.Optional;

public interface UserRoleRepository extends AbstractRepository<UserRole> {
    Optional<UserRole> findUserRoleByRoleName(String roleName);
}