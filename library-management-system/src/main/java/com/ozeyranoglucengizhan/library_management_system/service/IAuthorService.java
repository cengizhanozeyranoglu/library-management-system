package com.ozeyranoglucengizhan.library_management_system.service;

import com.ozeyranoglucengizhan.library_management_system.dto.DtoAuthor;

import java.util.List;

public interface IAuthorService {

    DtoAuthor createAuthor(DtoAuthor dtoAuthor);

    boolean deleteAuthor(Long id);

    DtoAuthor updateAuthor(DtoAuthor dtoAuthor, Long id);

    DtoAuthor getAuthorById(Long id);

    List<DtoAuthor> getAuthorByList();
}
