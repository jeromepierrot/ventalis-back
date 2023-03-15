package com.jpierrot.ventalismproducts.controllers;

import com.jpierrot.ventalismproducts.pojo.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    void addCategory(Category category);

    List<Category> getAllCategories();

    Optional<Category> getCategoryById(Long id);

    // TODO : not fully implemented yet
//    Optional<Category> getCategoryByName(String name);

    void updateCategory(Category category, Long id);

    void updateCategoryById(Category category, Long id);

    void deleteCategory(Long id);

    void deleteCategoryById(Long id);
}
