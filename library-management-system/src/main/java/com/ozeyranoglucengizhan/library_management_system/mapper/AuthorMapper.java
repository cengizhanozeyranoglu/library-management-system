package com.ozeyranoglucengizhan.library_management_system.mapper;

import com.ozeyranoglucengizhan.library_management_system.dto.DtoAuthor;
import com.ozeyranoglucengizhan.library_management_system.entity.Author;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AuthorMapper {

    AuthorMapper INSTANCE = Mappers.getMapper(AuthorMapper.class);

    DtoAuthor toDto(Author author);

    @Mapping(target = "books", ignore = true)
    Author toEntity(DtoAuthor dtoAuthor);

}
