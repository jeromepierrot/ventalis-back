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
     * @param category one category of product
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
     * @param id database's unique id for the category
     * @return Optional<Category> (empty if category not found)
     */
    @Override
    public Optional<Category> getCategoryById(Long id) {
        return this.categoryRepository.findById(id);
    }

    /**
     * Get a category's infos using its name
     * @param name category's name (should be unique)
     * @return Optional<Category>
     *     (empty if category not found)
     *     the first one, if multiple entities are found
     */
    // TODO : not fully implemented yet
/*    @Override
    public Optional<Category> getCategoryByName(String name) {
        this.categoryRepository.findByName(name);
        return Optional.empty();
    }*/

    /**
     * Update one existing category using its unique id, otherwise do nothing but
     * Note that only 'isVisible' status will be updated
     * @param category the category of product to update
     * @param id database's unique id for the category
     */
    public void updateCategory(Category category, Long id) {
        if(categoryRepository.existsById(id)) {
            // Does update only if the original data exists...
            Category categoryToUpdate = categoryRepository.getReferenceById(id);

            categoryToUpdate.setName(category.getName()); // updates name attribute
            categoryToUpdate.setIsVisible(category.getIsVisible()); // updates isVisible attribute

            categoryRepository.save(categoryToUpdate);
        } else {
            /* Does nothing if the original data doesn't exist,
                but Http response will still be Ok (code = 200)
                TODO: check if it is the correct behavior.
                Otherwise, try to return the correct Http code (204 = content does not exists ?)

            */
        }
    }

    /**
     * Delete a category from the database (Careful : permanent operation)
     * @param id database's unique id for the category
     */
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}
