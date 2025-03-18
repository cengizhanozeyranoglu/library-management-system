package com.ozeyranoglucengizhan.library_management_system.controller.impl;

import com.ozeyranoglucengizhan.library_management_system.controller.IReturnBookController;
import com.ozeyranoglucengizhan.library_management_system.dto.DtoReturnBookRequest;
import com.ozeyranoglucengizhan.library_management_system.dto.DtoReturnBookResponse;
import com.ozeyranoglucengizhan.library_management_system.service.IReturnBooksService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/library")

public class ReturnBookControllerImpl implements IReturnBookController {

    private final IReturnBooksService returnBooksService;

    @PostMapping("/createReturnBook")
    @Override
    public ResponseEntity<DtoReturnBookResponse> createReturnBook(
            @RequestBody DtoReturnBookRequest dtoReturnBookRequest,
            @RequestParam @DateTimeFormat (iso = DateTimeFormat.ISO.DATE) LocalDate returnDate) {
        return ResponseEntity.ok(returnBooksService.createReturnBooks(dtoReturnBookRequest,returnDate));
    }
}
