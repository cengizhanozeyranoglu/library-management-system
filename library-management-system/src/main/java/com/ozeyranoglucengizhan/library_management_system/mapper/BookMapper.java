package com.ozeyranoglucengizhan.library_management_system.mapper;

import com.ozeyranoglucengizhan.library_management_system.dto.DtoBooks;
import com.ozeyranoglucengizhan.library_management_system.entity.Author;
import com.ozeyranoglucengizhan.library_management_system.entity.Books;
import com.ozeyranoglucengizhan.library_management_system.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper
public interface BookMapper {

    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    @Mapping(target = "categoryId", expression = "java(mapToCategoryId(book))")
    @Mapping(target = "authorId", expression = "java(book.getAuthor().getId())")
    DtoBooks toDto(Books book);

    @Mapping(target = "author", source = "author")
    @Mapping(target = "category", source = "categories")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createDate", ignore = true)
    @Mapping(target = "updateDate", ignore = true)
    Books toBook(DtoBooks dtoBooks, Author author, List<Category> categories);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createDate", ignore = true)
    @Mapping(target = "author", source = "author")
    @Mapping(target = "category", source = "categories")
    @Mapping(target = "updateDate", ignore = true)
    void updateBook(DtoBooks dtoBooks, @MappingTarget Books book, Author author, List<Category> categories);

    default List<Long> mapToCategoryId(Books book) {
        List<Long> categoryIdList = book.getCategory().stream()
                .map(Category::getId)
                .collect(Collectors.toList());
        return categoryIdList;
    }
}
