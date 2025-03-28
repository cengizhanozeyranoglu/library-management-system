package com.ozeyranoglucengizhan.library_management_system.controller.impl;

import com.ozeyranoglucengizhan.library_management_system.controller.IReturnBookController;
import com.ozeyranoglucengizhan.library_management_system.dto.DtoReturnBookRequest;
import com.ozeyranoglucengizhan.library_management_system.dto.DtoReturnBookResponse;
import com.ozeyranoglucengizhan.library_management_system.service.IReturnBooksService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/library")

public class ReturnBookControllerImpl implements IReturnBookController {

    private final IReturnBooksService returnBooksService;

    @PostMapping("/createReturnBook")
    @Override
    public ResponseEntity<DtoReturnBookResponse> createReturnBook(
            @RequestBody @Valid DtoReturnBookRequest dtoReturnBookRequest,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate returnDate) {
        return ResponseEntity.ok(returnBooksService.createReturnBooks(dtoReturnBookRequest, returnDate));
    }

    @PutMapping(path = "payFine/{returnBookId}")
    @Override
    public ResponseEntity<Void> payFine(@PathVariable Long returnBookId) {
        returnBooksService.payFine(returnBookId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(path = "/getReturnBookList")
    @Override
    public ResponseEntity<List<DtoReturnBookResponse>> getAllReturnBooks() {
        return ResponseEntity.ok(returnBooksService.getAllReturnBooks());
    }

    @GetMapping(path = "/getReturnBookById/{id}")
    @Override
    public ResponseEntity<DtoReturnBookResponse> getReturnBookById(@PathVariable Long id) {
        return ResponseEntity.ok(returnBooksService.getReturnBookById(id));
    }
}
