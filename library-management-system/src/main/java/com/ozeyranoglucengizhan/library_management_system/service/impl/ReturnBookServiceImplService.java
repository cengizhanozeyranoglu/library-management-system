package com.ozeyranoglucengizhan.library_management_system.service.impl;

import com.ozeyranoglucengizhan.library_management_system.dto.DtoReturnBookRequest;
import com.ozeyranoglucengizhan.library_management_system.dto.DtoReturnBookResponse;
import com.ozeyranoglucengizhan.library_management_system.entity.BorrowedBooks;
import com.ozeyranoglucengizhan.library_management_system.entity.ReturnBooks;
import com.ozeyranoglucengizhan.library_management_system.enums.BookState;
import com.ozeyranoglucengizhan.library_management_system.exception.BaseException;
import com.ozeyranoglucengizhan.library_management_system.exception.NotFoundException;
import com.ozeyranoglucengizhan.library_management_system.mapper.ReturnBookMapper;
import com.ozeyranoglucengizhan.library_management_system.repository.BorrowedBooksRepository;
import com.ozeyranoglucengizhan.library_management_system.repository.ReturnBookRepository;
import com.ozeyranoglucengizhan.library_management_system.service.IReturnBooksService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReturnBookServiceImplService implements IReturnBooksService {

    private final ReturnBookRepository returnBookRepository;

    private final BorrowedBooksRepository borrowedBooksRepository;

    final double DAILY_FINE_RATE = 50.0;

    @Transactional
    @Override
    public DtoReturnBookResponse createReturnBooks(DtoReturnBookRequest request, LocalDate returnDate) {
        BorrowedBooks borrowedBook = borrowedBooksRepository.findById(request.getBorrowedBookId())
                .orElseThrow(() -> new RuntimeException("Borrowed book not found"));

        LocalDate dueDate = borrowedBook.getDueDate();

        int overdueDays = calculateOverdueDays(dueDate, returnDate);
        double fineAmount = calculateFine(overdueDays);

        ReturnBooks returnBook = mapToEntity(borrowedBook, returnDate, overdueDays, fineAmount);
        returnBookRepository.save(returnBook);

        borrowedBook.getBook().setBookState(BookState.AVAILABLE);
        borrowedBooksRepository.save(borrowedBook);


        DtoReturnBookResponse dtoResponse = ReturnBookMapper.INSTANCE
                .toResponse(borrowedBook, returnDate, overdueDays, fineAmount);
        return dtoResponse;
    }

    private ReturnBooks mapToEntity(BorrowedBooks borrowedBooks, LocalDate returnDate, int overdueDays, double fineAmount) {
        ReturnBooks returnBooks = new ReturnBooks();
        returnBooks.setReturnDate(returnDate);
        returnBooks.setOverdueDays(overdueDays);
        returnBooks.setFineAmount(fineAmount);
        returnBooks.setBorrowedBooks(borrowedBooks);
        return returnBooks;
    }

    @Override
    public void payFine(Long returnBookId) {
        ReturnBooks returnBook = returnBookRepository.findById(returnBookId)
                .orElseThrow(() -> new NotFoundException("Return book not found"));
        if (returnBook.getFineAmount() == 0) {
            throw new BaseException("No fine to pay for this return", HttpStatus.NO_CONTENT);
        }
        if (returnBook.isFinePaid()) {
            throw new BaseException("Fine as already been paid",HttpStatus.BAD_REQUEST);
        }
        returnBook.setFinePaid(true);
        returnBookRepository.save(returnBook);
    }

    @Override
    public List<DtoReturnBookResponse> getAllReturnBooks() {
        List<ReturnBooks> returnBooksList = returnBookRepository.findAll();
        List<DtoReturnBookResponse> dtoReturnBookResponseList = new ArrayList<>();
        for (ReturnBooks returnBook : returnBooksList) {
            DtoReturnBookResponse dtoReturnBookResponse = ReturnBookMapper.INSTANCE
                    .toResponse(returnBook.getBorrowedBooks(), returnBook.getReturnDate(), returnBook.getOverdueDays(), returnBook.getFineAmount());
            dtoReturnBookResponse.setFinePaid(returnBook.isFinePaid());
            dtoReturnBookResponseList.add(dtoReturnBookResponse);
        }
        return dtoReturnBookResponseList;
    }

    @Override
    public DtoReturnBookResponse getReturnBookById(Long returnBookId) {
        ReturnBooks returnBook = returnBookRepository.findById(returnBookId)
                .orElseThrow(() -> new NotFoundException("Return book not found"));
        DtoReturnBookResponse dtoReturnBookResponse = ReturnBookMapper.INSTANCE
                .toResponse(returnBook.getBorrowedBooks(), returnBook.getReturnDate(), returnBook.getOverdueDays(), returnBook.getFineAmount());
        dtoReturnBookResponse.setFinePaid(returnBook.isFinePaid());
        return dtoReturnBookResponse;
    }

    private double calculateFine(int overdueDays) {
        return overdueDays > 0 ? DAILY_FINE_RATE * overdueDays : 0.0;
    }

    private int calculateOverdueDays(LocalDate dueDate, LocalDate returnDate) {
        return returnDate.isAfter(dueDate) ? (int) ChronoUnit.DAYS.between(dueDate, returnDate) : 0;
    }
}
