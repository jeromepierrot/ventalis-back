package com.jpierrot.ventalismproducts.services.impl;

import com.jpierrot.ventalismproducts.services.CategoryService;
import com.jpierrot.ventalismproducts.repository.CategoryRepository;
import com.jpierrot.ventalismproducts.models.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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
    // TODO : not fully tested yet
    @Override
    public List<Category> getCategoryByName(String name) {
        return categoryRepository.findByName(name);
    }

    /**
     * Update one existing category, otherwise does nothing
     * Note : ONLY 'isVisible' status will be updated.
     * @param category the category of product to update
     */
    @Override
    public void updateCategory(Category category) {
        this.updateCategoryById(category, category.getId());
    }

    /**
     * Update one existing category using its unique id, otherwise does nothing
     * Note : ONLY 'isVisible' status will be updated
     * @param category the category of product to update
     * @param id database's unique id for the category
     */
    @Override
    public void updateCategoryById(Category category, Long id) {
        if(categoryRepository.existsById(id)) {
            // Does update only if the original data exists...
            Category categoryToUpdate = categoryRepository.getReferenceById(id);

            /* categoryToUpdate.setName(category.getName()); */ // uncomment this line to update name's attribute too
            categoryToUpdate.setIsVisible(category.getIsVisible()); // updates isVisible attribute
            categoryToUpdate.setModifiedDate(new Date(System.currentTimeMillis()));

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
     * Update all existing category using the string 'categoryName' given as parameter
     * Note : ONLY 'isVisible' status will be updated,
     * @param category the category of product to update
     * @param categoryName database's unique id for the category
     */
    @Override
    public void updateCategoryByName(Category category, String categoryName) {
        List<Category>categoriesToUpdate = categoryRepository.findByName(categoryName);
        if(!categoriesToUpdate.isEmpty()) {
            // Does update only if the original data exists...
            for(Category categoryToUpdate : categoriesToUpdate) {
                this.updateCategoryById(category, categoryToUpdate.getId());
            }
        } else {
            /* Does nothing if the original data doesn't exist,
                but Http response will still be Ok (code = 200)
                TODO: check if it is the correct behavior.
                Otherwise, try to return the correct Http code (204 = content does not exists ?)

            */
        }
    }

    /**
     * Delete a category from the database
     * ( CAREFUL : permanent operation )
     * Does the exact same action as `deleteCategoryById(Long id)` method
     * @param id database's unique id for the category
     */
    @Override
    public void deleteCategory(Long id) {
        deleteCategoryById(id);
    }

    /**
     * Delete a category from the database
     * ( CAREFUL : permanent operation )
     * @param id database's unique id for the category
     */
    public void deleteCategoryById(Long id) {
        categoryRepository.deleteById(id);
    }

    /**
     * Remove a category from the database.
     * Note : this operation will only UPDATE the original entry from the database (PUT Request),
     *        and no entry will be actuelly deleted from the Database (SQL UPDATE command).
     *        Therefore, it is safer to use rather than deleteCategoryById(id) for hiding/disabling the category
     * @param id database's unique id for the category
     */
    @Override
    public void removeCategoryById(Long id) {
        if(categoryRepository.existsById(id)) {
            Category categoryToRemove = categoryRepository.getReferenceById(id);

            categoryToRemove.setIsVisible(false); // set 'isVisible' attribute to 'false' so that the category is "hide/disabled"

            categoryRepository.save(categoryToRemove);
        } else {
            /* Does nothing if the original data doesn't exist,
                but Http response will still be Ok (code = 200)
                TODO: check if it is the correct behavior.
                Otherwise, try to return the correct Http code (204 = content does not exists ?)

            */
        }
    }

    /**
     * Remove a category from the database.
     * Note : Does the exact same action as 'removeCategoryById(id)' method.
     *        This operation will only UPDATE the original entry from the database (PUT Request),
     *        and no entry will be actuelly deleted from the Database (SQL UPDATE command).
     *        Therefore, it is safer to use rather than deleteCategoryById(id) for hiding/disabling the category
     * @param category actually, this parameter is not used and will be ignored
     * @param id database's unique id for the category
     */
    @Override
    public void removeCategory(Category category, Long id) {
        this.removeCategoryById(id); // set 'isVisible' attribute to 'false' so that the category is "hide/disabled"
    }

    /**
     * Remove ALL categories with the given name from the database
     * Note : this operation does NOT DELETE any original entries from the database.
     * Therefore, it is safer to use rather than deleteCategoryByName(id) for hiding/disabling the category
     * @param name of the categories to remove/hide
     */
    @Override
    public void removeAllCategoriesByName(String name) {
        List<Category> categoriesToRemove = categoryRepository.findByName(name);
        if(!categoriesToRemove.isEmpty()) {
            for(Category categoryToRemove:categoriesToRemove) {
                categoryToRemove.setIsVisible(false); // set 'isVisible' attribute to 'false' so that each category is "hide/disabled"
                categoryRepository.save(categoryToRemove);
            }
        } else {
            /* Does nothing if the original data doesn't exist,
                but Http response will still be Ok (code = 200)
                TODO: check if it is the correct behavior.
                Otherwise, try to return the correct Http code (204 = content does not exists ?)

            */
        }
    }

    /**
     * Remove the FIRST found category with the given name from the database
     * Note : this operation does NOT DELETE any original entries from the database.
     * Therefore, it is safer to use rather than deleteCategoryByName(id) for hiding/disabling the category
     * @param name of the categories to remove/hide
     */
    @Override
    public void removeCategoryByName(String name) {
        List<Category> categoriesToRemove = categoryRepository.findByName(name);
        if(!categoriesToRemove.isEmpty()) {
            Category categoryToRemove = categoriesToRemove.get(0);
            categoryToRemove.setIsVisible(false); // set 'isVisible' attribute to 'false' so that each category is "hide/disabled"
            categoryRepository.save(categoryToRemove);
        } else {
            /* Does nothing if the original data doesn't exist,
                but Http response will still be Ok (code = 200)
                TODO: check if it is the correct behavior.
                Otherwise, try to return the correct Http code (204 = content does not exists ?)

            */
        }
    }
}
