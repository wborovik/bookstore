package com.example.bookstore.repository;

import com.example.bookstore.domain.UserAccount;
import com.example.bookstore.repository.common.AbstractRepository;

import java.util.Optional;

public interface UserAccountRepository extends AbstractRepository<UserAccount> {
    Optional<UserAccount> findUserAccountByLogin(String login);
}