package com.ozeyranoglucengizhan.library_management_system.controller;

import com.ozeyranoglucengizhan.library_management_system.dto.DtoReturnBookRequest;
import com.ozeyranoglucengizhan.library_management_system.dto.DtoReturnBookResponse;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;

public interface IReturnBookController {

ResponseEntity<DtoReturnBookResponse> createReturnBook(DtoReturnBookRequest dtoReturnBookRequest, LocalDate returnDate);

}
