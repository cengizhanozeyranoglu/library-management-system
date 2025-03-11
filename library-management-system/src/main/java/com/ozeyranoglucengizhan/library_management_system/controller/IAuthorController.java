package com.ozeyranoglucengizhan.library_management_system.controller;

import com.ozeyranoglucengizhan.library_management_system.dto.DtoAuthor;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IAuthorController {

    ResponseEntity<DtoAuthor> createAuthor(DtoAuthor dtoAuthor);

    ResponseEntity<Boolean> deleteAuthor(Long id);

    ResponseEntity<DtoAuthor> updateAuthor(DtoAuthor dtoAuthor, Long id);

    ResponseEntity<DtoAuthor> getDtoAuthorById(Long id);

    ResponseEntity<List<DtoAuthor>> getAuthorsList();
}
