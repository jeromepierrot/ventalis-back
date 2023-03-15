package com.jpierrot.ventalismproducts.webservice;

import com.jpierrot.ventalismproducts.api.ApiRouter;
import com.jpierrot.ventalismproducts.controllers.CategoryService;
import com.jpierrot.ventalismproducts.controllers.ProductService;
import com.jpierrot.ventalismproducts.pojo.Product;
import com.jpierrot.ventalismproducts.webservice.exceptions.ProductNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(ApiRouter.REST_CATALOG)
//@CrossOrigin(origins = "http://localhost:4200")
public class ProductWs {
    private static final String NOT_FOUND_ERROR_MESSAGE = "Aucun produit trouvé";

    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;

    @PostMapping("/add")
    public void addProduct(@RequestBody Product product) { productService.addProduct(product); }

    // TODO : not fully implemented yet
/*    @PostMapping("/{categoryName}/add")
    public void addProductWithCategory(@RequestBody Product product, @RequestParam String categoryName) {
        productService.addProductWithCategory(
                product,
                (Category c) -> categoryService.getCategoryByName(categoryName);
        );
    }*/

    @GetMapping
    public List<Product> getAllProducts() throws ProductNotFoundException {
        List<Product> products = productService.getAllProducts();
        if(products.isEmpty()) throw new ProductNotFoundException(NOT_FOUND_ERROR_MESSAGE);
        return products;
    }

    @GetMapping("/search/{name}")
    public List<Product> getProductByName (@PathVariable String name) throws ProductNotFoundException {
        List<Product> product = productService.getProductsByLabel(name);
        if(product.isEmpty()) throw new ProductNotFoundException(NOT_FOUND_ERROR_MESSAGE);

        return product;
    }

    @GetMapping("/{id}")
    public Optional<Product> getProductById (@PathVariable Long id) throws ProductNotFoundException {
        Optional<Product> product = productService.getProductById(id);
        if(product.isEmpty()) throw new ProductNotFoundException(NOT_FOUND_ERROR_MESSAGE);

        return product;
    }

    @PutMapping(value = "/update/{id}")
    public void updateProduct (@RequestBody Product product, @PathVariable Long id) {
        productService.updateProductById(product, id);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteProduct (@PathVariable Long id) {
        productService.deleteProductById(id);
    }

}
