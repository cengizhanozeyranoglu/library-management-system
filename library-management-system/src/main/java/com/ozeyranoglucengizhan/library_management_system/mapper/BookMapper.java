package com.ozeyranoglucengizhan.library_management_system.mapper;

import com.ozeyranoglucengizhan.library_management_system.dto.DtoBooks;
import com.ozeyranoglucengizhan.library_management_system.entity.Books;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookMapper {

    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    @Mapping(target = "categoryId", ignore = true)
    @Mapping(target = "authorId", ignore = true)
    DtoBooks toDto(Books book);

    @Mapping(target = "author", ignore = true)
    Books toBook(DtoBooks dtoBooks);
}
