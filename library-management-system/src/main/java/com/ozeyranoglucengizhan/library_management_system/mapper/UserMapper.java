package com.ozeyranoglucengizhan.library_management_system.mapper;

import com.ozeyranoglucengizhan.library_management_system.dto.DtoUsers;
import com.ozeyranoglucengizhan.library_management_system.entity.Users;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "borrowedBooks", ignore = true)
    Users toEntity(DtoUsers dtoUsers);

    DtoUsers toDto(Users users);

    @Mapping(target = "borrowedBooks", ignore = true)
    void updateUser(DtoUsers dtoUser, @MappingTarget Users users);

    List<DtoUsers>  toDtoUserList (List<Users> list);
}
