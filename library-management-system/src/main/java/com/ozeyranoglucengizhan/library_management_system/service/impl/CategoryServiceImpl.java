package com.ozeyranoglucengizhan.library_management_system.service.impl;

import com.ozeyranoglucengizhan.library_management_system.dto.DtoCategory;
import com.ozeyranoglucengizhan.library_management_system.entity.Category;
import com.ozeyranoglucengizhan.library_management_system.mapper.CategoryMapper;
import com.ozeyranoglucengizhan.library_management_system.repository.CategoryRepository;
import com.ozeyranoglucengizhan.library_management_system.service.ICategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryServiceImpl implements ICategoryService {

    private final CategoryRepository categoryRepository;


    @Override
    public DtoCategory createCategory(DtoCategory dtoCategory) {
        Category category = CategoryMapper.INSTANCE.toEntity(dtoCategory);
        Category savedCategory = categoryRepository.save(category);
        return CategoryMapper.INSTANCE.toDto(savedCategory);
    }

    @Override
    public boolean deleteCategory(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category id:" + id + "not found."));
        categoryRepository.delete(category);
        log.info("Category id:" + id + "deleted.");
        return true;
    }

    @Override
    public DtoCategory updateCategory(DtoCategory dtoCategory, Long id) {
        return categoryRepository.findById(id)
                .map(dbCategory->{
                    dbCategory.setCategoryName(dtoCategory.getCategoryName());
                    return CategoryMapper.INSTANCE.toDto(categoryRepository.save(dbCategory));
                })
                .orElseThrow(()->new RuntimeException("Category id "+ id + " not found"));
    }

    @Override
    public DtoCategory getCategoryById(Long id) {
        return categoryRepository.findById(id)
                .map(CategoryMapper.INSTANCE::toDto)
                .orElseThrow(()->new RuntimeException("Category id: " + id + "not found"));
    }

    @Override
    public List<DtoCategory> getCategoryList() {
        List<Category> categoryList = categoryRepository.findAll();
        List<DtoCategory> dtoCategoryList = new ArrayList<>();
        for(Category category : categoryList){
            dtoCategoryList.add(CategoryMapper.INSTANCE.toDto(category));
        }
        return dtoCategoryList;
    }
}
