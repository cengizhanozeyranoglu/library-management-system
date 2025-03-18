package com.ozeyranoglucengizhan.library_management_system.service;

import com.ozeyranoglucengizhan.library_management_system.dto.DtoReturnBookRequest;
import com.ozeyranoglucengizhan.library_management_system.dto.DtoReturnBookResponse;

import java.time.LocalDate;

public interface IReturnBooksService {

    DtoReturnBookResponse createReturnBooks(DtoReturnBookRequest  request, LocalDate returnDate);

    void payFine(Long returnBookId);
}
