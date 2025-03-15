package com.ozeyranoglucengizhan.library_management_system.controller;

import com.ozeyranoglucengizhan.library_management_system.dto.DtoAuthor;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IAuthorController {

    ResponseEntity<Void> createAuthor(DtoAuthor dtoAuthor);

    ResponseEntity<Void> deleteAuthor(Long id);

    ResponseEntity<Void> updateAuthor(DtoAuthor dtoAuthor, Long id);

    ResponseEntity<DtoAuthor> getDtoAuthorById(Long id);

    ResponseEntity<List<DtoAuthor>> getAuthorsList();
}
