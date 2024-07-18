package com.coderk.task_manager.service;

import com.coderk.task_manager.entity.Category;

import java.util.List;

public interface CategoryService {
    Category createCategory(Category category);
    Category getCategoryById(Long id);
    Category updateCategory(Category category);
    void deleteCategory(Long id);
    List<Category> getAllCategories();
}