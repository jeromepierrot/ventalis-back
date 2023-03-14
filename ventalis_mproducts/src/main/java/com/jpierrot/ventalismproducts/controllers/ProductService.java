package com.jpierrot.ventalismproducts.controllers;

import com.jpierrot.ventalismproducts.pojo.Category;
import com.jpierrot.ventalismproducts.pojo.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    void addProduct(Product product);

    // TODO : not fully implemented yet
    void addProductWithCategory(Product product, Category category);

    List<Product> getAllProducts();

    Optional<Product> getProductById(Long id);

    void updateProduct(Product product, Long id);

    void deleteProduct(Long id);
}