package com.pwr.awt.librarysystem.service;

import com.pwr.awt.librarysystem.entity.Category;
import com.pwr.awt.librarysystem.exception.NotFoundException;
import com.pwr.awt.librarysystem.exception.OperationException;
import com.pwr.awt.librarysystem.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(final CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category findByCategoryId(long id) {
        return categoryRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    public void deleteById(long id){
        if(!categoryRepository.existsById(id)){
            throw new OperationException();
        }
        categoryRepository.deleteById(id);
    }
    public Category saveCategory(Category category) {
        if (category.getCategoryId() != null && categoryRepository.existsById(category.getCategoryId())) {
            throw new OperationException();
        }
        return categoryRepository.save(category);
    }

}
