package com.ozeyranoglucengizhan.library_management_system.controller.impl;

import com.ozeyranoglucengizhan.library_management_system.controller.IAuthorController;
import com.ozeyranoglucengizhan.library_management_system.dto.DtoAuthor;
import com.ozeyranoglucengizhan.library_management_system.service.IAuthorService;
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
    public ResponseEntity<DtoAuthor> createAuthor(@RequestBody DtoAuthor dtoAuthor) {
        DtoAuthor dtoAuthors = authorService.createAuthor(dtoAuthor);
        if (dtoAuthors != null) {
            return ResponseEntity.ok().body(dtoAuthors);
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping(path = "/deleteAuthor/{id}")
    @Override
    public ResponseEntity<Boolean> deleteAuthor(@PathVariable Long id) {
        if (authorService.deleteAuthor(id)) {
            return ResponseEntity.ok(true);
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping(path = "/updateAuthor/{id}")
    @Override
    public ResponseEntity<DtoAuthor> updateAuthor(@RequestBody DtoAuthor dtoAuthor, @PathVariable Long id) {
        try {
            DtoAuthor updateAuthor = authorService.updateAuthor(dtoAuthor, id);
            return ResponseEntity.ok().body(updateAuthor);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping(path = "/getAuthorById/{id}")
    @Override
    public ResponseEntity<DtoAuthor> getDtoAuthorById(@PathVariable Long id) {
        DtoAuthor dtoAuthor = authorService.getAuthorById(id);
        if (dtoAuthor == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(dtoAuthor);
    }

    @GetMapping(path = "/getAuthorsList")
    @Override
    public ResponseEntity<List<DtoAuthor>> getAuthorsList() {
        List<DtoAuthor> dtoAuthorsList = authorService.getAuthorByList();
        return dtoAuthorsList.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok().body(dtoAuthorsList);
    }
}
