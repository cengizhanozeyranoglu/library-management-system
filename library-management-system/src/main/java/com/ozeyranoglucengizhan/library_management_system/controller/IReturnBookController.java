package com.ozeyranoglucengizhan.library_management_system.controller;

import com.ozeyranoglucengizhan.library_management_system.dto.DtoReturnBookRequest;
import com.ozeyranoglucengizhan.library_management_system.dto.DtoReturnBookResponse;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.List;

public interface IReturnBookController {

    ResponseEntity<DtoReturnBookResponse> createReturnBook(DtoReturnBookRequest dtoReturnBookRequest, LocalDate returnDate);

    ResponseEntity<Void> payFine(Long returnBookId);

    ResponseEntity<List<DtoReturnBookResponse>> getAllReturnBooks();

    ResponseEntity<DtoReturnBookResponse> getReturnBookById(Long id);

}
