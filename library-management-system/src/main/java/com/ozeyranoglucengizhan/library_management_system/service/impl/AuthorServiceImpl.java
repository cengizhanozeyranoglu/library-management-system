package com.ozeyranoglucengizhan.library_management_system.service.impl;

import com.ozeyranoglucengizhan.library_management_system.dto.DtoAuthor;
import com.ozeyranoglucengizhan.library_management_system.entity.Author;
import com.ozeyranoglucengizhan.library_management_system.mapper.AuthorMapper;
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
    public DtoAuthor createAuthor(DtoAuthor dtoAuthor) {

        Author author = AuthorMapper.INSTANCE.toEntity(dtoAuthor);
        authorRepository.save(author);
        return AuthorMapper.INSTANCE.toDto(author);
    }

    @Override
    public boolean deleteAuthor(Long id) {
        Author author = authorRepository.findById(id).orElseThrow(() -> new RuntimeException("Authorid :" + id + "not found"));
        authorRepository.delete(author);
        log.info("Author deleted id:" + id);
        return true;

    }

    @Override
    public DtoAuthor updateAuthor(DtoAuthor dtoAuthor, Long id) {
        return authorRepository.findById(id)
                .map(dbAuthor -> {
                    dbAuthor.setAuthorName(dtoAuthor.getAuthorName());
                    dbAuthor.setAuthorLastName(dtoAuthor.getAuthorLastName());
                    return AuthorMapper.INSTANCE.toDto(authorRepository.save(dbAuthor));
                })
                .orElseThrow(() -> {
                    log.info("Author update failed");
                    return new RuntimeException("Authorid :" + id + "not found");
                });
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
        List<DtoAuthor> dtoAuthorsList = new ArrayList<>();
        for (Author author : authorList) {
            dtoAuthorsList.add(AuthorMapper.INSTANCE.toDto(author));
        }
        return dtoAuthorsList;
    }
}
