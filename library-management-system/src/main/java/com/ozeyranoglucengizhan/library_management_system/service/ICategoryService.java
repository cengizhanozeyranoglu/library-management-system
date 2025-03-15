package com.ozeyranoglucengizhan.library_management_system.service;

import com.ozeyranoglucengizhan.library_management_system.dto.DtoCategory;

import java.util.List;

public interface ICategoryService {

    void createCategory(DtoCategory dtoCategory);

    void deleteCategory(Long id);

    void updateCategory(DtoCategory dtoCategory,Long id);

    DtoCategory getCategoryById(Long id);

    List<DtoCategory> getCategoryList();

}
