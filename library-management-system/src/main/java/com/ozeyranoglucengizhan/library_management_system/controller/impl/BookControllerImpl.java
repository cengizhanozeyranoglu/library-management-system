package com.ozeyranoglucengizhan.library_management_system.controller.impl;

import com.ozeyranoglucengizhan.library_management_system.controller.IBookController;
import com.ozeyranoglucengizhan.library_management_system.dto.DtoBooks;
import com.ozeyranoglucengizhan.library_management_system.service.IBookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/library")
@RequiredArgsConstructor
public class BookControllerImpl implements IBookController {

    private final IBookService bookService;

    @PostMapping(path = "/createBook")
    @Override
    public ResponseEntity<Void> createBooks(@RequestBody @Valid DtoBooks dtoBooks) {
        bookService.createBook(dtoBooks);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/deleteBook/{id}")
    @Override
    public ResponseEntity<Boolean> deleteBook(@PathVariable Long id) {
        return ResponseEntity.ok(bookService.deleteBook(id));
    }

    @PutMapping(path = "/updateBook/{id}")
    @Override
    public ResponseEntity<Void> updateBook(@RequestBody @Valid DtoBooks dtoBooks, @PathVariable Long id) {
        bookService.updateBook(dtoBooks, id);
        return ResponseEntity.ok().build();
    }

    @GetMapping(path = "/getBookList")
    @Override
    public ResponseEntity<List<DtoBooks>> getAllBooks() {
        return ResponseEntity.ok(bookService.getBookList());
    }

    @GetMapping(path = "/getBookById/{id}")
    @Override
    public ResponseEntity<DtoBooks> getBookById(@PathVariable Long id) {
        return ResponseEntity.ok(bookService.getBookById(id));
    }
}
