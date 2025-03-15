package com.ozeyranoglucengizhan.library_management_system.controller.impl;

import com.ozeyranoglucengizhan.library_management_system.controller.ICategoryController;
import com.ozeyranoglucengizhan.library_management_system.dto.DtoCategory;
import com.ozeyranoglucengizhan.library_management_system.service.ICategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/library")
@RequiredArgsConstructor
public class CategoryControllerImpl implements ICategoryController {

    private final ICategoryService categoryService;

    @PostMapping(path = "/createCategory")
    @Override
    public ResponseEntity<Void> createCategory(@RequestBody DtoCategory category) {
        categoryService.createCategory(category);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/deleteCategoryById/{id}")
    @Override
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping(path = "/updateCategoryById/{id}")
    @Override
    public ResponseEntity<Void> updateCategory(@RequestBody DtoCategory dtoCategory, @PathVariable Long id) {
        categoryService.updateCategory(dtoCategory, id);
        return ResponseEntity.ok().build();
    }

    @GetMapping(path = "/getCategoryById/{id}")
    @Override
    public ResponseEntity<DtoCategory> getCategoryById(@PathVariable Long id) {
        return ResponseEntity.ok(categoryService.getCategoryById(id));
    }

    @GetMapping(path = "/getCategoryList")
    @Override
    public ResponseEntity<List<DtoCategory>> getCategoryList() {
        return ResponseEntity.ok(categoryService.getCategoryList());
    }
}
