package com.ozeyranoglucengizhan.library_management_system.controller;

import com.ozeyranoglucengizhan.library_management_system.dto.DtoBooks;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IBookController {

    ResponseEntity<Void> createBooks(DtoBooks dtoBooks);

    ResponseEntity<Boolean> deleteBook(Long id);

    ResponseEntity<Void> updateBook(DtoBooks dtoBooks, Long id);

    ResponseEntity<List<DtoBooks>> getAllBooks();

    ResponseEntity<DtoBooks> getBookById(Long id);
}
