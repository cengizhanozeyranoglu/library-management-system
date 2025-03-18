package com.ozeyranoglucengizhan.library_management_system.service.impl;

import com.ozeyranoglucengizhan.library_management_system.dto.DtoBorrowBookResponse;
import com.ozeyranoglucengizhan.library_management_system.dto.DtoBorrowedBooksRequest;
import com.ozeyranoglucengizhan.library_management_system.entity.Books;
import com.ozeyranoglucengizhan.library_management_system.entity.BorrowedBooks;
import com.ozeyranoglucengizhan.library_management_system.entity.Users;
import com.ozeyranoglucengizhan.library_management_system.enums.BookState;
import com.ozeyranoglucengizhan.library_management_system.mapper.BorrowBookMapper;
import com.ozeyranoglucengizhan.library_management_system.mapper.BorrowBookMapperImpl;
import com.ozeyranoglucengizhan.library_management_system.repository.BooksRepository;
import com.ozeyranoglucengizhan.library_management_system.repository.BorrowedBooksRepository;
import com.ozeyranoglucengizhan.library_management_system.repository.UsersRepository;
import com.ozeyranoglucengizhan.library_management_system.service.IBorrowBookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Slf4j
@RequiredArgsConstructor
public class BorrowBookServiceImpl implements IBorrowBookService {

    private final BorrowedBooksRepository borrowedBooksRepository;

    private final BooksRepository booksRepository;

    private final UsersRepository usersRepository;

    @Transactional
    @Override
    public DtoBorrowBookResponse createBorrowBook(DtoBorrowedBooksRequest dtoBorrowedBooksRequest) {
        Books book = getBookIfAvailable(dtoBorrowedBooksRequest.getBookId());
        Users user = getUserIfAvailable(dtoBorrowedBooksRequest.getUserId());
        DtoBorrowBookResponse response = BorrowBookMapper.INSTANCE.toBorrowBookResponse(book, user);
        BorrowedBooks borrowedBooks = BorrowBookMapperImpl.INSTANCE.toBorrowBookEntity(book, user);
        book.setBookState(BookState.BORROWED);
        borrowedBooksRepository.save(borrowedBooks);
        return response;
    }

    public Users getUserIfAvailable(Long userId) {
        Users user = usersRepository.findById(userId).orElseThrow(() -> new RuntimeException("User Not Found"));
        return user;
    }

    public Books getBookIfAvailable(Long bookId) {
        Books book = booksRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found"));
        log.info("Book find, book id:" + bookId);
        if (book.getBookState() == BookState.BORROWED) {
            throw new RuntimeException("Book is Borrowed");
        }
        log.info("Book id:" + bookId + "ready for borrow");
        return book;
    }

}
