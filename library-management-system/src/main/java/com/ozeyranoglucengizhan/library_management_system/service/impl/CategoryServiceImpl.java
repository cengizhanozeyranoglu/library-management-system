package com.ozeyranoglucengizhan.library_management_system.service.impl;

import com.ozeyranoglucengizhan.library_management_system.dto.DtoCategory;
import com.ozeyranoglucengizhan.library_management_system.entity.Category;
import com.ozeyranoglucengizhan.library_management_system.exception.NotFoundException;
import com.ozeyranoglucengizhan.library_management_system.mapper.CategoryMapper;
import com.ozeyranoglucengizhan.library_management_system.repository.CategoryRepository;
import com.ozeyranoglucengizhan.library_management_system.service.ICategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryServiceImpl implements ICategoryService {

    private final CategoryRepository categoryRepository;


    @Override
    public void createCategory(DtoCategory dtoCategory) {
        Category category = CategoryMapper.INSTANCE.toEntity(dtoCategory);
        categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new NotFoundException("Category id:" + id + "not found."));
        categoryRepository.delete(category);
        log.info("Category id:" + id + "deleted.");
    }

    @Override
    public void updateCategory(DtoCategory dtoCategory, Long id) {
        categoryRepository.findById(id)
                .map(dbCategory -> {
                    dbCategory.setCategoryName(dtoCategory.getCategoryName());
                    return CategoryMapper.INSTANCE.toDto(categoryRepository.save(dbCategory));
                })
                .orElseThrow(() -> new NotFoundException("Category id " + id + " not found"));
    }

    @Override
    public DtoCategory getCategoryById(Long id) {
        return categoryRepository.findById(id)
                .map(CategoryMapper.INSTANCE::toDto)
                .orElseThrow(() -> new NotFoundException("Category id: " + id + "not found"));
    }

    @Override
    public List<DtoCategory> getCategoryList() {
        List<Category> categoryList = categoryRepository.findAll();
        List<DtoCategory> dtoCategoryList = CategoryMapper.INSTANCE.toDtoCategories(categoryList);
        return dtoCategoryList;
    }
}
