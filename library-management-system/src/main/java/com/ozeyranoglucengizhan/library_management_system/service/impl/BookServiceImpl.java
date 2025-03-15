package com.ozeyranoglucengizhan.library_management_system.service.impl;

import com.ozeyranoglucengizhan.library_management_system.dto.DtoBooks;
import com.ozeyranoglucengizhan.library_management_system.entity.Author;
import com.ozeyranoglucengizhan.library_management_system.entity.Books;
import com.ozeyranoglucengizhan.library_management_system.entity.Category;
import com.ozeyranoglucengizhan.library_management_system.mapper.BookMapper;
import com.ozeyranoglucengizhan.library_management_system.repository.AuthorRepository;
import com.ozeyranoglucengizhan.library_management_system.repository.BooksRepository;
import com.ozeyranoglucengizhan.library_management_system.repository.CategoryRepository;
import com.ozeyranoglucengizhan.library_management_system.service.IBookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Slf4j
@Service
@RequiredArgsConstructor
public class BookServiceImpl implements IBookService {

    private final BooksRepository bookRepository;

    private final AuthorRepository authorRepository;

    private final CategoryRepository categoryRepository;

    @Override
    public void createBook(DtoBooks dtoBooks) {
        Author author = getAuthorIfExist(dtoBooks.getAuthorId());
        List<Category> categoriesList = getCategoryIfExist(dtoBooks.getCategoryId());

        Books book = BookMapper.INSTANCE.toBook(dtoBooks, author, categoriesList);
        bookRepository.save(book);
        log.info("Book saved succesfully.");
    }

    @Override
    public boolean deleteBook(Long id) {
        Books book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book id " + id + "not found."));
        bookRepository.delete(book);
        log.info("Book id " + id + " deleted.");
        return true;
    }

    @Override
    public void updateBook(DtoBooks dtoBooks, Long id) {
        Books book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Books not in the database, check book id: " + id));
        Author author = getAuthorIfExist(dtoBooks.getAuthorId());
        List<Category> categories = getCategoryIfExist(dtoBooks.getCategoryId());
        BookMapper.INSTANCE.updateBook(dtoBooks, book, author, categories);
        bookRepository.save(book);
        log.info("Book updated succesfully");
    }

    @Override
    public List<DtoBooks> getBookList() {
        return bookRepository.findAll()
                .stream()
                .map(book -> {
                    DtoBooks dtoBooks = BookMapper.INSTANCE.toDto(book);
                    return dtoBooks;
                })
                .collect(Collectors.toList());
    }

    @Override
    public DtoBooks getBookById(Long id) {
        Optional<Books> optBook = bookRepository.findById(id);
        if (optBook.isPresent()) {
            Books book = optBook.get();
            DtoBooks dtoBook = BookMapper.INSTANCE.toDto(book);
            return dtoBook;
        } else return null;
    }

    public Author getAuthorIfExist(Long authorId) {
        return authorRepository.findById(authorId)
                .orElseThrow(() -> new RuntimeException("Author not found id: " + authorId));
    }

    public List<Category> getCategoryIfExist(List<Long> categoryId) {
        List<Category> categories = categoryRepository.findAllById(categoryId);
        if (categories.size() != categoryId.size()) {
            throw new RuntimeException("One or more categories not found, check category ids.");
        }
        return categories;
    }
}