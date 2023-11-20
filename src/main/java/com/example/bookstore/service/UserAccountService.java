package com.example.bookstore.service;

import com.example.bookstore.domain.UserAccount;
import com.example.bookstore.repository.UserAccountRepository;
import com.example.bookstore.service.common.AbstractService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class UserAccountService extends AbstractService<UserAccount, UserAccountRepository> implements UserDetailsService {
    private final UserRoleService roleService;
    public UserAccountService(UserAccountRepository repository, UserRoleService roleService) {
        super(repository);
        this.roleService = roleService;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        UserAccount user = repository.findUserAccountByLogin(login).orElseThrow(() -> {
            log.error(String.format("ERROR: user %s not found", login));
            return new UsernameNotFoundException(String.format("User %s not found", login));
        });
        return new User(
                user.getLogin(),
                user.getPassword(),
                user.getRoles().stream().map(role
                        -> new SimpleGrantedAuthority(role.getRoleName())).collect(Collectors.toList())
        );
    }

    @Override
    public UserAccount createEntity(UserAccount user) throws Exception {
        user.setRoles(List.of(roleService.findUserRoleByRoleName("ROLE_USER")));
        return super.createEntity(user);
    }
}