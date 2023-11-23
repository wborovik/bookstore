package com.example.bookstore.mapper;

import com.example.bookstore.domain.UserAccount;
import com.example.bookstore.dto.UserAccountDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserAccountMapper {
    UserAccountDto userAccountToUserAccountDto(UserAccount userAccount);
}
