package com.ozeyranoglucengizhan.library_management_system.controller;

import com.ozeyranoglucengizhan.library_management_system.dto.DtoBooks;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IBookController {

    ResponseEntity<Boolean> createBooks(DtoBooks dtoBooks);

    ResponseEntity<Boolean> deleteBook(Long id);

    ResponseEntity<Boolean> updateBook(Long id, DtoBooks dtoBooks);

    ResponseEntity<List<DtoBooks>> getAllBooks();

    ResponseEntity<DtoBooks> getBookById(Long id);
}
