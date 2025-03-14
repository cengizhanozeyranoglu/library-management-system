package com.ozeyranoglucengizhan.library_management_system.service;

import com.ozeyranoglucengizhan.library_management_system.dto.DtoBooks;

import java.util.List;

public interface IBookService {

    void createBook(DtoBooks dtoBooks);

    boolean deleteBook(Long id);

    void updateBook(DtoBooks dtoBooks, Long id);

    List<DtoBooks> getBookList();

    DtoBooks getBookById(Long id);
}
