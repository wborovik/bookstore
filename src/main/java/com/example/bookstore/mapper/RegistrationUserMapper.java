package com.example.bookstore.mapper;

import com.example.bookstore.domain.UserAccount;
import com.example.bookstore.dto.RegistrationUserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RegistrationUserMapper {
UserAccount userDtoToUserAccount(RegistrationUserDto userDto);
}