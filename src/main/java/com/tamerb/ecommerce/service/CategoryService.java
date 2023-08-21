package com.tamerb.ecommerce.service;

import com.tamerb.ecommerce.model.Category;
import com.tamerb.ecommerce.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category readCategory(String categoryName) {
        return categoryRepository.findByCategoryName(categoryName);
    }

    public void createCategory(Category category) {
        categoryRepository.save(category);
    }

    public List<Category> listCategories() {
        return categoryRepository.findAll();
    }

    public Optional<Category> readCategory(Integer categoryID) {
        return categoryRepository.findById(categoryID);
    }

    public void updateCategory(Integer categoryID, Category newCategory) {
        Optional<Category> optionalCategory = categoryRepository.findById(categoryID);
        if (optionalCategory.isPresent()) {
            Category category = optionalCategory.get();
            category.setCategoryName(newCategory.getCategoryName());
            category.setDescription(newCategory.getDescription());
            category.setImageUrl(newCategory.getImageUrl());
            categoryRepository.save(category);
        } else {
            throw new IllegalArgumentException("No category found with the specified categoryID.");
        }
    }
}
