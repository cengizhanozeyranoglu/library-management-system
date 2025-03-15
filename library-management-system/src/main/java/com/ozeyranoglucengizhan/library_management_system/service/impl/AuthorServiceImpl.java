package com.ozeyranoglucengizhan.library_management_system.service.impl;

import com.ozeyranoglucengizhan.library_management_system.dto.DtoAuthor;
import com.ozeyranoglucengizhan.library_management_system.entity.Author;
import com.ozeyranoglucengizhan.library_management_system.mapper.AuthorMapper;
import com.ozeyranoglucengizhan.library_management_system.mapper.BookMapper;
import com.ozeyranoglucengizhan.library_management_system.repository.AuthorRepository;
import com.ozeyranoglucengizhan.library_management_system.service.IAuthorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements IAuthorService {

    private final AuthorRepository authorRepository;


    @Override
    public void createAuthor(DtoAuthor dtoAuthor) {
        Author author = AuthorMapper.INSTANCE.toEntity(dtoAuthor);
        authorRepository.save(author);
    }

    @Override
    public void deleteAuthor(Long id) {
        Author author = authorRepository.findById(id).orElseThrow(() -> new RuntimeException("Authorid :" + id + "not found"));
        authorRepository.delete(author);
        log.info("Author deleted id:" + id);
    }

    @Override
    public void updateAuthor(DtoAuthor dtoAuthor, Long id) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Authorid:" + id + "not found"));
        AuthorMapper.INSTANCE.updateAuthor(dtoAuthor, author);
        authorRepository.save(author);
        log.info("Author updated id:" + id);
    }

    @Override
    public DtoAuthor getAuthorById(Long id) {
        return authorRepository.findById(id)
                .map(AuthorMapper.INSTANCE::toDto)
                .orElseThrow(() -> new RuntimeException("Authorid:" + id + "not found"));
    }

    @Override
    public List<DtoAuthor> getAuthorByList() {
        List<Author> authorList = authorRepository.findAll();
        return AuthorMapper.INSTANCE.toDtoAuthorList(authorList);

    }
}
