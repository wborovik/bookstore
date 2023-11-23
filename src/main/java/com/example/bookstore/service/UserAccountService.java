package com.example.bookstore.service;

import com.example.bookstore.domain.UserAccount;
import com.example.bookstore.dto.RegistrationUserDto;
import com.example.bookstore.mapper.RegistrationUserMapper;
import com.example.bookstore.repository.UserAccountRepository;
import com.example.bookstore.service.common.AbstractService;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserAccountService extends AbstractService<UserAccount, UserAccountRepository> implements UserDetailsService {
    private final UserRoleService roleService;
    private final RegistrationUserMapper userMapper;
    private final PasswordEncoder encoder;

    public UserAccountService(UserAccountRepository repository, UserRoleService roleService,
                              RegistrationUserMapper userMapper, @Lazy PasswordEncoder passwordEncoder) {
        super(repository);
        this.roleService = roleService;
        this.userMapper = userMapper;
        this.encoder = passwordEncoder;
    }

    public UserAccount findUserByLogin(String login) {
        return repository.findUserAccountByLogin(login).orElseThrow(() ->
                new UsernameNotFoundException(String.format("User %s not found", login)));
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        UserAccount user = findUserByLogin(login);
        return new User(
                user.getLogin(),
                user.getPassword(),
                user.getRoles().stream().map(role
                        -> new SimpleGrantedAuthority(role.getRoleName())).collect(Collectors.toList())
        );
    }

    public UserAccount registerNewUser(RegistrationUserDto userDto) {
        UserAccount user = userMapper.userDtoToUserAccount(userDto);
        user.setRoles(List.of(roleService.findUserRoleByRoleName("ROLE_USER")));
        user.setPassword(encoder.encode(userDto.getPassword()));

        return super.createEntity(user);
    }
}