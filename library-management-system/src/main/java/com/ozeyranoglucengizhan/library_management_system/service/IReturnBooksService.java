package com.ozeyranoglucengizhan.library_management_system.service;

import com.ozeyranoglucengizhan.library_management_system.dto.DtoReturnBookRequest;
import com.ozeyranoglucengizhan.library_management_system.dto.DtoReturnBookResponse;

import java.time.LocalDate;
import java.util.List;

public interface IReturnBooksService {

    DtoReturnBookResponse createReturnBooks(DtoReturnBookRequest request, LocalDate returnDate);

    void payFine(Long returnBookId);

    List<DtoReturnBookResponse> getAllReturnBooks();

    DtoReturnBookResponse getReturnBookById(Long returnBookId);
}
