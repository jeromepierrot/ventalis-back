package com.jpierrot.ventalismproducts.webservice;

import com.jpierrot.ventalismproducts.api.ApiRouter;
import com.jpierrot.ventalismproducts.controllers.CategoryService;
import com.jpierrot.ventalismproducts.pojo.Category;
import com.jpierrot.ventalismproducts.webservice.exceptions.CategoryNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(ApiRouter.REST_CATEGORY)
//@CrossOrigin(origins = "http://localhost:4200")
public class CategoryWs {
    private static final String ERROR_MESSAGE = "Aucune catégorie trouvée";
    @Autowired
    CategoryService categoryService;

    @PostMapping(value = "/add")
    public void addCategory(@RequestBody Category category) {
        categoryService.addCategory(category);
    }

    @GetMapping
    public List<Category> getAllCategories() throws CategoryNotFoundException {
        List<Category> categories = categoryService.getAllCategories();
        if (categories.isEmpty()) throw new CategoryNotFoundException(ERROR_MESSAGE);
        return categories;
    }

    // TODO/FIX : not working, to be fixed
    @GetMapping("/{id}")
    public Optional<Category> getCategoryById (@PathVariable Long id) throws CategoryNotFoundException {
        Optional<Category> category = categoryService.getCategoryById(id);
        if(category.isEmpty()) throw new CategoryNotFoundException(ERROR_MESSAGE);
        return category;
    }

    // TODO/FIX : not working, to be fixed
    @PutMapping(value = "/update/{id}")
    public void  updateCategory (@RequestBody Category category, @PathVariable Long id){
        categoryService.updateCategory(category, id);
    }

    // TODO : implement delete methods (needed ?)
}
