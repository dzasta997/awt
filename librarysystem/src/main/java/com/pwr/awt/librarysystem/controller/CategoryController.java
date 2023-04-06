package com.pwr.awt.librarysystem.controller;

import com.pwr.awt.librarysystem.dto.CategoryDTO;
import com.pwr.awt.librarysystem.entity.Category;
import com.pwr.awt.librarysystem.mapper.CategoryMapper;
import com.pwr.awt.librarysystem.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("categories")
public class CategoryController {
    private final CategoryMapper categoryMapper;
    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryMapper categoryMapper, CategoryService categoryService) {
        this.categoryMapper = categoryMapper;
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> getAllCategories() {
        List<Category> categories = categoryService.findAll();
        return new ResponseEntity<>(categoryMapper.toDto(categories), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> getCategory(@PathVariable long id) {
        Category category = categoryService.findByCategoryId(id);
        return new ResponseEntity<>(categoryMapper.toDto(category), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CategoryDTO> postCategory(@RequestBody CategoryDTO categoryDTO) {
        Category categorySaved = categoryService.saveCategory(categoryMapper.toEntity(categoryDTO));
        return new ResponseEntity<>(categoryMapper.toDto(categorySaved), HttpStatus.OK);
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity deleteCategory(@PathVariable long id) {
        categoryService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
