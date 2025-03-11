package com.ozeyranoglucengizhan.library_management_system.mapper;

import com.ozeyranoglucengizhan.library_management_system.dto.DtoCategory;
import com.ozeyranoglucengizhan.library_management_system.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    DtoCategory toDto(Category category);

    @Mapping(target = "books", ignore = true)
    Category toEntity(DtoCategory dtoCategory);
}
