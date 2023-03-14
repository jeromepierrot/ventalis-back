package com.jpierrot.ventalismproducts.controllers.impl;

import com.jpierrot.ventalismproducts.controllers.CategoryService;
import com.jpierrot.ventalismproducts.database.CategoryRepository;
import com.jpierrot.ventalismproducts.pojo.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    /**
     * Create and add a new category into the database
     * @param category
     */
    @Override
    public void addCategory(Category category) { this.categoryRepository.save(category); }

    /**
     * Get all categories available
     * @return a List of Categories
     */
    @Override
    public List<Category> getAllCategories() {
        return this.categoryRepository.findAll();
    }

    /**
     * Get a category's infos using its unique id
     * @param id
     * @return Optional<Category> (empty if category not found)
     */
    @Override
    public Optional<Category> getCategoryById(Long id) {
        return Optional.of(this.categoryRepository.getReferenceById(id)) ;
    }

    /**
     * Update one category using its unique id
     * Note that only 'isVisible' status will be updated
     * @param category
     * @param id
     */
    public void updateCategory(Category category, Long id) {
        Category categoryToUpdate = categoryRepository.getReferenceById(id);
        if (categoryToUpdate.getId() != null) {
            // categoryToUpdate.setName(category.getName());
            categoryToUpdate.setIsVisible(category.getIsVisible());
        }
    }

    /**
     * Delete a category from the database (Careful : permanent operation)
     * @param id
     */
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}
