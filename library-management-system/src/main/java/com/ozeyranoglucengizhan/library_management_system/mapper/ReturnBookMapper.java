package com.ozeyranoglucengizhan.library_management_system.mapper;

import com.ozeyranoglucengizhan.library_management_system.dto.DtoReturnBookResponse;
import com.ozeyranoglucengizhan.library_management_system.entity.BorrowedBooks;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.time.LocalDate;

@Mapper
public interface ReturnBookMapper {

    ReturnBookMapper INSTANCE = Mappers.getMapper(ReturnBookMapper.class);

    @Mapping(target = "bookTitle", expression = "java(borrowedBook.getBook().getTitle())")
    @Mapping(target = "authorFirstName", expression = "java(borrowedBook.getBook().getAuthor().getAuthorName())")
    @Mapping(target = "authorLastName", expression = "java(borrowedBook.getBook().getAuthor().getAuthorLastName())")
    @Mapping(target = "userFirstName", expression = "java(borrowedBook.getUser().getUserFirstName())")
    @Mapping(target = "userLastName", expression = "java(borrowedBook.getUser().getUserLastName())")
    @Mapping(target = "borrowDate", expression = "java(borrowedBook.getBorrowedDate())")
    @Mapping(target = "returnDate", source = "returnDate")
    @Mapping(target = "overdueDays", source = "overdueDays")
    @Mapping(target = "fineAmount", source = "fineAmount")
    @Mapping(target = "finePaid", ignore = true)
    DtoReturnBookResponse toResponse(BorrowedBooks borrowedBook, LocalDate returnDate,int overdueDays, double fineAmount);
}
