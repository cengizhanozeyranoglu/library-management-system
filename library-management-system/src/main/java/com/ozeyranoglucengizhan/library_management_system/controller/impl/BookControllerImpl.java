package com.ozeyranoglucengizhan.library_management_system.controller.impl;

import com.ozeyranoglucengizhan.library_management_system.controller.IBookController;
import com.ozeyranoglucengizhan.library_management_system.dto.DtoBooks;
import com.ozeyranoglucengizhan.library_management_system.service.IBookService;
import lombok.RequiredArgsConstructor;
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
    public ResponseEntity<Boolean> createBooks(@RequestBody DtoBooks dtoBooks) {
        boolean createdBooks = bookService.createBook(dtoBooks);
        return createdBooks ? ResponseEntity.ok().build() : ResponseEntity.noContent().build();
    }

    @DeleteMapping(path = "/deleteBook/{id}")
    @Override
    public ResponseEntity<Boolean> deleteBook(@PathVariable Long id) {
        if (bookService.deleteBook(id)) {
            return ResponseEntity.ok(true);
        }
        return ResponseEntity.noContent().build();
    }

    @PutMapping(path = "/updateBook/{id}")
    @Override
    public ResponseEntity<Boolean> updateBook(@PathVariable Long id, @RequestBody DtoBooks dtoBooks) {
        if (bookService.updateBook(dtoBooks, id)) {
            return ResponseEntity.ok(true);
        }
        return ResponseEntity.noContent().build();
    }

    @GetMapping(path = "/getBookList")
    @Override
    public ResponseEntity<List<DtoBooks>> getAllBooks() {
        List<DtoBooks> dtoBooksList = bookService.getBookList();
        return dtoBooksList.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok().body(dtoBooksList);
    }

    @GetMapping(path = "/getBookById/{id}")
    @Override
    public ResponseEntity<DtoBooks> getBookById(@PathVariable Long id) {
        DtoBooks dtoBook = bookService.getBookById(id);
        if (dtoBook == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(dtoBook);
    }
}
