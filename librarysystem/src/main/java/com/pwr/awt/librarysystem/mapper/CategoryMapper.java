package com.pwr.awt.librarysystem.mapper;

import com.pwr.awt.librarysystem.dto.CategoryDTO;
import com.pwr.awt.librarysystem.entity.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper extends ApplicationMapper<Category, CategoryDTO> {


    @Override
    public Category toEntity(final CategoryDTO categoryDTO) {
        if(categoryDTO==null){
            return null;
        }
        return new Category()
                .setCategoryId(categoryDTO.getCategoryId())
                .setName(categoryDTO.getName())
                .setDescription(categoryDTO.getDescription());
    }

    @Override
    public CategoryDTO toDto(final Category category) {
        if(category==null) {
            return null;
        }
        return new CategoryDTO()
                .setCategoryId(category.getCategoryId())
                .setName(category.getName())
                .setDescription(category.getDescription());
    }
}
