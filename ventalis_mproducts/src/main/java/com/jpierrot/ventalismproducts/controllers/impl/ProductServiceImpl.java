package com.jpierrot.ventalismproducts.controllers.impl;

import com.jpierrot.ventalismproducts.controllers.ProductService;
import com.jpierrot.ventalismproducts.database.ProductRepository;
import com.jpierrot.ventalismproducts.pojo.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    /**
     * Create and add a new product into the database
     * @param product
     */
    @Override
    public void addProduct(Product product) { productRepository.save(product); }

    /**
     * Get all products available
     * @return a List of products
     */
    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    /**
     * Get a product's infos using its unique id
     * @param id
     * @return Optional<Product> (empty if product not found)
     */
    @Override
    public Optional<Product> getProductById(Long id) {
        return Optional.of(productRepository.getReferenceById(id));
    }

    /**
     * Update one product using its unique id
     * @param product
     * @param id
     */
    @Override
    public void updateProduct(Product product, Long id) {
        Product productToUpdate = productRepository.getReferenceById(id);
        if (productToUpdate.getId() != null) {
            productToUpdate.setLabel(product.getLabel());
            productToUpdate.setDescription(product.getDescription());
            productToUpdate.setCategory(product.getCategory());
            productToUpdate.setUnitPriceHT(product.getUnitPriceHT());
            productToUpdate.setMinOrderQuantity(product.getMinOrderQuantity());
            productToUpdate.setImageResourceUrl(product.getImageResourceUrl());
            productToUpdate.setIsVisible(product.getIsVisible());
        }
    }

    /**
     * Delete a product from the database (Careful : permanent operation)
     * @param id
     */
    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
