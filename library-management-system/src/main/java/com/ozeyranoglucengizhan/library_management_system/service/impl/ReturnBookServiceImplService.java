package com.ozeyranoglucengizhan.library_management_system.service.impl;

import com.ozeyranoglucengizhan.library_management_system.dto.DtoReturnBookRequest;
import com.ozeyranoglucengizhan.library_management_system.dto.DtoReturnBookResponse;
import com.ozeyranoglucengizhan.library_management_system.entity.BorrowedBooks;
import com.ozeyranoglucengizhan.library_management_system.entity.ReturnBooks;
import com.ozeyranoglucengizhan.library_management_system.enums.BookState;
import com.ozeyranoglucengizhan.library_management_system.mapper.ReturnBookMapper;
import com.ozeyranoglucengizhan.library_management_system.repository.BorrowedBooksRepository;
import com.ozeyranoglucengizhan.library_management_system.repository.ReturnBookRepository;
import com.ozeyranoglucengizhan.library_management_system.service.IReturnBooksService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Service
@RequiredArgsConstructor
public class ReturnBookServiceImplService implements IReturnBooksService {

    private final ReturnBookRepository returnBookRepository;

    private final BorrowedBooksRepository borrowedBooksRepository;

    final double DAILY_FINE_RATE = 50.0;


    @Override
    public DtoReturnBookResponse createReturnBooks(DtoReturnBookRequest request, LocalDate returnDate) {
        BorrowedBooks borrowedBook = borrowedBooksRepository.findById(request.getBorrowedBookId())
                .orElseThrow(() -> new RuntimeException("Borrowed book not found"));


        LocalDate dueDate = borrowedBook.getDueDate();

        ReturnBooks returnBooks = new ReturnBooks();
        returnBooks.setBorrowedBooks(borrowedBook);
        returnBooks.setReturnDate(returnDate);

        int overdueDays = calculateOverdueDays(dueDate, returnDate);
        double fineAmount = calculateFine(overdueDays);

        returnBooks.setOverdueDays(overdueDays);
        returnBooks.setFineAmount(fineAmount);
        borrowedBook.getBook().setBookState(BookState.AVAILABLE);
        borrowedBooksRepository.save(borrowedBook);
        returnBookRepository.save(returnBooks);

        DtoReturnBookResponse dtoResponse = ReturnBookMapper.INSTANCE.toResponse(borrowedBook, returnDate);
        dtoResponse.setOverdueDays(overdueDays);
        dtoResponse.setFineAmount(fineAmount);
        return dtoResponse;
    }

    private double calculateFine(int overdueDays) {
        return overdueDays > 0 ? DAILY_FINE_RATE * overdueDays : 0.0;
    }

    private int calculateOverdueDays(LocalDate dueDate, LocalDate returnDate) {
        return returnDate.isAfter(dueDate) ? (int) ChronoUnit.DAYS.between(dueDate, returnDate) : 0;
    }
}
