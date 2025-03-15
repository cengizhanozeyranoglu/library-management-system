package com.ozeyranoglucengizhan.library_management_system.service;

import com.ozeyranoglucengizhan.library_management_system.dto.DtoAuthor;

import java.util.List;

public interface IAuthorService {

    void createAuthor(DtoAuthor dtoAuthor);

    void deleteAuthor(Long id);

    void updateAuthor(DtoAuthor dtoAuthor, Long id);

    DtoAuthor getAuthorById(Long id);

    List<DtoAuthor> getAuthorByList();
}
