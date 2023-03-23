package com.jpierrot.ventalismproducts.api.webservice;

import com.jpierrot.ventalismproducts.api.ApiRouter;
import com.jpierrot.ventalismproducts.services.CategoryService;
import com.jpierrot.ventalismproducts.models.Category;
import com.jpierrot.ventalismproducts.api.webservice.exceptions.CategoryNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(ApiRouter.REST_CATEGORY)
@CrossOrigin(origins = "http://localhost:4200")
public class CategoryWs {
    private static final String NOT_FOUND_ERROR_MESSAGE = "Aucune catégorie trouvée";
    @Autowired
    CategoryService categoryService;

    @PostMapping("/add")
    public void addCategory(@RequestBody Category category) {
        categoryService.addCategory(category);
    }

    @GetMapping
    public List<Category> getAllCategories() throws CategoryNotFoundException {
        List<Category> categories = categoryService.getAllCategories();
        if (categories.isEmpty()) throw new CategoryNotFoundException(NOT_FOUND_ERROR_MESSAGE);
        return categories;
    }

    // TODO : not tested yet
    @GetMapping("/{categoryName}")
    public List<Category> getCategoryByName (@PathVariable String categoryName) throws CategoryNotFoundException {
        List<Category> foundCategories = categoryService.getCategoryByName(categoryName);
        if (foundCategories.isEmpty()) throw new CategoryNotFoundException(NOT_FOUND_ERROR_MESSAGE);
        return foundCategories;
    }

    @GetMapping("/id/{id}")
    public Optional<Category> getCategoryById (@PathVariable Long id) throws CategoryNotFoundException {
        Optional<Category> category = categoryService.getCategoryById(id);
        if(category.isEmpty()) throw new CategoryNotFoundException(NOT_FOUND_ERROR_MESSAGE);
        return category;
    }

    // TODO : not fully tested yet (route)
    @PutMapping(value = "/update/id/{id}")
    public void  updateCategory (@RequestBody Category category, @PathVariable Long id){
        categoryService.updateCategoryById(category, id);
    }

    // TODO : not fully tested yet
    @PutMapping(value = "/update/{categoryName}")
    public void  updateCategory (@RequestBody Category category, @PathVariable String categoryName){
        categoryService.updateCategoryByName(category, categoryName);
    }

    // TODO : not fully tested yet (route) // TODO: this method should not being implemented for production
    @DeleteMapping("/delete/id/{id}")
    public void deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategoryById(id);
    }

    // TODO : not fully tested yet
    @PutMapping("/remove/id/{id}")
    public void removeCategory(@PathVariable Long id) {
        categoryService.removeCategoryById(id);
    }

    // TODO : not fully tested yet
    @PutMapping("/remove/{categoryName}")
    public void removeCategory(@PathVariable String categoryName) {
        categoryService.removeCategoryByName(categoryName);
    }
}
