package com.ozeyranoglucengizhan.library_management_system.mapper;

import com.ozeyranoglucengizhan.library_management_system.dto.DtoAuthor;
import com.ozeyranoglucengizhan.library_management_system.entity.Author;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AuthorMapper {

    AuthorMapper INSTANCE = Mappers.getMapper(AuthorMapper.class);

    DtoAuthor toDto(Author author);

    @Mapping(target = "books", ignore = true)
    Author toEntity(DtoAuthor dtoAuthor);

    List<DtoAuthor> toDtoAuthorList(List<Author> authorList);

    @Mapping(target = "id",ignore = true)
    @Mapping(target = "createDate",ignore = true)
    @Mapping(target = "updateDate",ignore = true)
    void updateAuthor(DtoAuthor dtoAuthor, @MappingTarget Author author);

}
