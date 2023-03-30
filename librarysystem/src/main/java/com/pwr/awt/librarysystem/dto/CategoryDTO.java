package com.pwr.awt.librarysystem.dto;

import lombok.Data;
import lombok.experimental.SuperBuilder;


public class CategoryDTO {
    private Long categoryId;
    private String name;
    private String description;

    public CategoryDTO() {
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public CategoryDTO setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
        return this;
    }

    public String getName() {
        return name;
    }

    public CategoryDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public CategoryDTO setDescription(String description) {
        this.description = description;
        return this;
    }
}
