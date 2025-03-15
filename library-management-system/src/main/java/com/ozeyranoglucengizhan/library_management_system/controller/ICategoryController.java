package com.ozeyranoglucengizhan.library_management_system.controller;

import com.ozeyranoglucengizhan.library_management_system.dto.DtoCategory;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ICategoryController {

    ResponseEntity<Void> createCategory(DtoCategory category);

    ResponseEntity<Void> deleteCategory(Long id);

    ResponseEntity<Void> updateCategory(DtoCategory dtoCategory, Long id);

    ResponseEntity<DtoCategory> getCategoryById(Long id);

    ResponseEntity<List<DtoCategory>> getCategoryList();
}
