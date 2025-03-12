package com.ozeyranoglucengizhan.library_management_system.controller.impl;

import com.ozeyranoglucengizhan.library_management_system.controller.ICategoryController;
import com.ozeyranoglucengizhan.library_management_system.dto.DtoCategory;
import com.ozeyranoglucengizhan.library_management_system.service.ICategoryService;
import lombok.RequiredArgsConstructor;
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
    public ResponseEntity<DtoCategory> createCategory(@RequestBody DtoCategory category) {
        DtoCategory createdCategory = categoryService.createCategory(category);
        if (createdCategory != null) {
            return ResponseEntity.ok().body(createdCategory);
        }
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(path = "/deleteCategoryById/{id}")
    @Override
    public ResponseEntity<Boolean> deleteCategory(@PathVariable Long id) {
        if (categoryService.deleteCategory(id)) {
            return ResponseEntity.ok(true);
        }
        return ResponseEntity.noContent().build();
    }

    @PutMapping(path = "/updateCategoryById/{id}")
    @Override
    public ResponseEntity<DtoCategory> updateCategory(@RequestBody DtoCategory dtoCategory, @PathVariable Long id) {
        DtoCategory updatedCategory = categoryService.updateCategory(dtoCategory, id);
        if (updatedCategory != null && !updatedCategory.getCategoryName().isEmpty()) {
            return ResponseEntity.ok().body(updatedCategory);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(path = "/getCategoryById/{id}")
    @Override
    public ResponseEntity<DtoCategory> getCategoryById(@PathVariable Long id) {
        DtoCategory category = categoryService.getCategoryById(id);
        if (category == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(category);
    }

    @GetMapping(path = "/getCategoryList")
    @Override
    public ResponseEntity<List<DtoCategory>> getCategoryList() {
        List<DtoCategory> dtoCategoryList = categoryService.getCategoryList();
        return dtoCategoryList.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(dtoCategoryList);
    }
}
