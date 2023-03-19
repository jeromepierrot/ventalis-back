package com.jpierrot.ventalismproducts.services;

import com.jpierrot.ventalismproducts.models.Category;
import com.jpierrot.ventalismproducts.models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    void addProduct(Product product);

    // TODO : not fully implemented yet
    void addProductWithCategory(Product product, Category category);

    List<Product> getAllProducts();

    // TODO : see if refactorization needed
    Optional<Product> getProductById(Long id);

    List<Product> getProductsByLabel(String name);

    // TODO : not fully implemented
    List<Product> getProductsByCategory(Category category);

    // TODO : not fully implemented
    List<Product> getProductsByDescription(String description);

    void updateProductById(Product product, Long id);

    void updateProduct(Product product, Long id);

    void deleteProductById(Long id);

    void deleteProduct(Long id);
}