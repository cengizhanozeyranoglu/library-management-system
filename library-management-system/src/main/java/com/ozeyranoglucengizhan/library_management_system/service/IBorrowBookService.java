package com.ozeyranoglucengizhan.library_management_system.service;

import com.ozeyranoglucengizhan.library_management_system.dto.DtoBorrowBookResponse;
import com.ozeyranoglucengizhan.library_management_system.dto.DtoBorrowedBooksRequest;

import java.util.List;

public interface IBorrowBookService {

    DtoBorrowBookResponse createBorrowBook(DtoBorrowedBooksRequest dtoBorrowedBooksRequest);

    List<DtoBorrowBookResponse> getBorrowedBookList();

    DtoBorrowBookResponse getBorrowBookById(Long id);
}
