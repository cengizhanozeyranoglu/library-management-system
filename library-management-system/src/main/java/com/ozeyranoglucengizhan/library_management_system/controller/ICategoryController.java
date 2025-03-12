package com.ozeyranoglucengizhan.library_management_system.controller;

import com.ozeyranoglucengizhan.library_management_system.dto.DtoCategory;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ICategoryController {

    ResponseEntity<DtoCategory> createCategory(DtoCategory category);

    ResponseEntity<Boolean> deleteCategory(Long id);

    ResponseEntity<DtoCategory> updateCategory(DtoCategory dtoCategory, Long id);

    ResponseEntity<DtoCategory> getCategoryById(Long id);

    ResponseEntity<List<DtoCategory>> getCategoryList();
}
