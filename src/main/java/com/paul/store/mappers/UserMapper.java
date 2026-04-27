package com.paul.store.mappers;

import com.paul.store.dto.CurrentUserDto;
import com.paul.store.dto.RegisterUserRequest;
import com.paul.store.dto.UpdateUserRequest;
import com.paul.store.dto.UserDto;
import com.paul.store.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);

    User toEntity(RegisterUserRequest request);

    void update(UpdateUserRequest request, @MappingTarget User user);

    CurrentUserDto toCurrentUserDto(User user);
}
