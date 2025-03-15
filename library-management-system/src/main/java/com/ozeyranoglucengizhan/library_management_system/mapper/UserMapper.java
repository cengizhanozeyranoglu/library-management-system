package com.ozeyranoglucengizhan.library_management_system.mapper;

import com.ozeyranoglucengizhan.library_management_system.dto.DtoUsers;
import com.ozeyranoglucengizhan.library_management_system.entity.Users;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "borrowedBooks",ignore = true)
    Users toEntity(DtoUsers dtoUsers);

    @Mapping(target = "borrowedBooksId", ignore = true)
    DtoUsers toDto(Users users);
}
