package com.ozeyranoglucengizhan.library_management_system.controller.impl;

import com.ozeyranoglucengizhan.library_management_system.controller.IAuthorController;
import com.ozeyranoglucengizhan.library_management_system.dto.DtoAuthor;
import com.ozeyranoglucengizhan.library_management_system.service.IAuthorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/library")
@RequiredArgsConstructor
public class AuthorControllerImpl implements IAuthorController {

    private final IAuthorService authorService;

    @PostMapping(path = "/createAuthor")
    @Override
    public ResponseEntity<Void> createAuthor(@RequestBody @Valid DtoAuthor dtoAuthor) {
        authorService.createAuthor(dtoAuthor);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/deleteAuthor/{id}")
    @Override
    public ResponseEntity<Void> deleteAuthor(@PathVariable Long id) {
        authorService.deleteAuthor(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(path = "/updateAuthor/{id}")
    @Override
    public ResponseEntity<Void> updateAuthor(@RequestBody @Valid DtoAuthor dtoAuthor, @PathVariable Long id) {
        authorService.updateAuthor(dtoAuthor, id);
        return ResponseEntity.ok().build();
    }

    @GetMapping(path = "/getAuthorById/{id}")
    @Override
    public ResponseEntity<DtoAuthor> getDtoAuthorById(@PathVariable Long id) {
        DtoAuthor dtoAuthor = authorService.getAuthorById(id);
        return ResponseEntity.ok().body(dtoAuthor);
    }

    @GetMapping(path = "/getAuthorsList")
    @Override
    public ResponseEntity<List<DtoAuthor>> getAuthorsList() {
        List<DtoAuthor> dtoAuthorsList = authorService.getAuthorByList();
        return ResponseEntity.ok().body(dtoAuthorsList);
    }
}
