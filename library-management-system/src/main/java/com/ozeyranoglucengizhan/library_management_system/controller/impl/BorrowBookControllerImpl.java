package com.ozeyranoglucengizhan.library_management_system.controller.impl;

import com.ozeyranoglucengizhan.library_management_system.controller.IBorrowBookController;
import com.ozeyranoglucengizhan.library_management_system.dto.DtoBorrowBookResponse;
import com.ozeyranoglucengizhan.library_management_system.dto.DtoBorrowedBooksRequest;
import com.ozeyranoglucengizhan.library_management_system.service.IBorrowBookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/library")
@RequiredArgsConstructor
public class BorrowBookControllerImpl implements IBorrowBookController {

    private final IBorrowBookService borrowBookService;

    @PostMapping(path = "/createBorrowBook")
    @Override
    public ResponseEntity<DtoBorrowBookResponse> createBorrowBook(@RequestBody @Valid DtoBorrowedBooksRequest dtoBorrowedBooksRequest) {
        return ResponseEntity.ok(borrowBookService.createBorrowBook(dtoBorrowedBooksRequest));
    }

    @GetMapping(path = "/getBorrowBookList")
    @Override
    public ResponseEntity<List<DtoBorrowBookResponse>> getBorrowedBookList() {
        return ResponseEntity.ok(borrowBookService.getBorrowedBookList());
    }

    @GetMapping(path = "getBorrowBookById/{id}")
    @Override
    public ResponseEntity<DtoBorrowBookResponse> getBorrowedBookById(@PathVariable Long id) {
        return ResponseEntity.ok(borrowBookService.getBorrowBookById(id));
    }
}
