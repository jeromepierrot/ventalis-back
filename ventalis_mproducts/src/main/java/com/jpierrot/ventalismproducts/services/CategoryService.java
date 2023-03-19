package com.jpierrot.ventalismproducts.services;

import com.jpierrot.ventalismproducts.models.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    /**
     * Create and add a new category into the database
     * @param category one category of product
     */
    void addCategory(Category category);

    /**
     * Get all available categories
     * @return a List of Categories
     */
    List<Category> getAllCategories();

    /**
     * Get a category's infos using its unique id
     * @param id database's unique id for the category
     * @return Optional<Category> (empty if category not found)
     */
    Optional<Category> getCategoryById(Long id);

    /**
     * Get a category's infos using its name
     * @param name category's name (should be unique)
     * @return Optional<Category>
     *     (empty if category not found)
     *     the first one, if multiple entities are found
     */
    // TODO : not fully tested yet
    List<Category> getCategoryByName(String name);


    /**
     * Update one existing category, otherwise does nothing
     * Note : ONLY 'isVisible' status will be updated.
     * @param category the category of product to update
     */
    void updateCategory(Category category);

    /**
     * Update one existing category using its unique id, otherwise does nothing
     * Note : ONLY 'isVisible' status will be updated.
     * @param category the category of product to update
     * @param id database's unique id for the category
     */
    void updateCategoryById(Category category, Long id);

    /**
     * Update all existing category using the string 'categoryName' given as parameter
     * Note : ONLY 'isVisible' status will be updated,
     * @param category the category of product to update
     * @param categoryName database's unique id for the category
     */
    // TODO : not fully tested yet
    void updateCategoryByName(Category category, String categoryName);

    /**
     * Delete a category from the database
     * ( CAREFUL : permanent operation )
     * Does the exact same action as `deleteCategoryById(Long id)` method
     * @param id database's unique id for the category
     */
    void deleteCategory(Long id);

    /**
     * Delete a category from the database
     * ( CAREFUL : permanent operation )
     * @param id database's unique id for the category
     */
    void deleteCategoryById(Long id);

    /**
     * Remove a category from the database.
     * Note : this operation will only UPDATE the original entry from the database (PUT Request),
     *        and no entry will be actuelly deleted from the Database (SQL UPDATE command).
     *        Therefore, it is safer to use rather than deleteCategoryById(id) for hiding/disabling the category
     * @param id database's unique id for the category
     */
    void removeCategoryById(Long id);

    /**
     * Remove a category from the database.
     * Note : Does the exact same action as 'removeCategoryById(id)' method.
     *        This operation will only UPDATE the original entry from the database (PUT Request),
     *        and no entry will be actuelly deleted from the Database (SQL UPDATE command).
     *        Therefore, it is safer to use rather than deleteCategoryById(id) for hiding/disabling the category
     * @param category actually, this parameter is not used and will be ignored
     * @param id database's unique id for the category
     */
    void removeCategory(Category category, Long id);

    /**
     * Remove ALL categories with the given name from the database
     * Note : this operation does NOT DELETE any original entries from the database.
     * Therefore, it is safer to use rather than deleteCategoryByName(id) for hiding/disabling the category
     * @param name of the categories to remove/hide
     */
    void removeAllCategoriesByName(String name);

    /**
     * Remove the FIRST found category with the given name from the database
     * Note : this operation does NOT DELETE any original entries from the database.
     * Therefore, it is safer to use rather than deleteCategoryByName(id) for hiding/disabling the category
     * @param name of the categories to remove/hide
     */
    void removeCategoryByName(String name);
}
