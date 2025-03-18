package com.ozeyranoglucengizhan.library_management_system.mapper;

import com.ozeyranoglucengizhan.library_management_system.dto.DtoBorrowBookResponse;
import com.ozeyranoglucengizhan.library_management_system.entity.Books;
import com.ozeyranoglucengizhan.library_management_system.entity.BorrowedBooks;
import com.ozeyranoglucengizhan.library_management_system.entity.Users;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.time.LocalDate;

@Mapper
public interface BorrowBookMapper {

    BorrowBookMapper INSTANCE = Mappers.getMapper(BorrowBookMapper.class);

    @Mapping(target = "bookTitle", expression = "java(book.getTitle())")
    @Mapping(target = "authorFirstName", expression = "java(book.getAuthor().getAuthorName())")
    @Mapping(target = "authorLastName", expression = "java(book.getAuthor().getAuthorLastName())")
    @Mapping(target = "userFirstName", expression = "java(user.getUserFirstName())")
    @Mapping(target = "userLastName", expression = "java(user.getUserLastName())")
    @Mapping(target = "borrowDate", expression = "java(mapBorrowDate())")
    @Mapping(target = "dueDate", expression = "java(mapDueDate())")
    DtoBorrowBookResponse toBorrowBookResponse(Books book, Users user);

    @Mapping(target = "book", source = "book")
    @Mapping(target = "user", source = "user")
    @Mapping(target = "borrowedDate", expression = "java(mapBorrowDate())")
    @Mapping(target = "dueDate", expression = "java(mapDueDate())")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createDate", ignore = true)
    @Mapping(target = "updateDate", ignore = true)
    BorrowedBooks toBorrowBookEntity(Books book, Users user);

    default LocalDate mapBorrowDate() {
        return LocalDate.now();
    }

    default LocalDate mapDueDate() {
        return LocalDate.now().plusDays(14);
    }
}
