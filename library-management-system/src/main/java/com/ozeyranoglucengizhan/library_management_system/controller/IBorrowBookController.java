package com.ozeyranoglucengizhan.library_management_system.controller;

import com.ozeyranoglucengizhan.library_management_system.dto.DtoBorrowBookResponse;
import com.ozeyranoglucengizhan.library_management_system.dto.DtoBorrowedBooksRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IBorrowBookController {

    ResponseEntity<DtoBorrowBookResponse> createBorrowBook(DtoBorrowedBooksRequest dtoBorrowedBooksRequest);

    ResponseEntity<List<DtoBorrowBookResponse>> getBorrowedBookList();

    ResponseEntity<DtoBorrowBookResponse> getBorrowedBookById(Long id);
}
