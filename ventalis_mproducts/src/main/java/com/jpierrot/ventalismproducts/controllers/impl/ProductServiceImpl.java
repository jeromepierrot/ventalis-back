package com.jpierrot.ventalismproducts.controllers.impl;

import com.jpierrot.ventalismproducts.controllers.ProductService;
import com.jpierrot.ventalismproducts.database.CategoryRepository;
import com.jpierrot.ventalismproducts.database.ProductRepository;
import com.jpierrot.ventalismproducts.pojo.Category;
import com.jpierrot.ventalismproducts.pojo.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    /**
     * Create and add a new product into the database
     * Carefeul : if the product's name already exists, it will be added anyway
     * TODO : check if this can be improved and not adding the product
     *        if another product with this name already exists
     * @param product the product object to add to the database
     */
    @Override
    public void addProduct(Product product) { this.productRepository.save(product); }

    // TODO : neither fully implemented nor tested yet
    /**
     * Add both product and its assigned category to the database.
     * @param product the product object to add to the database
     * @param category the category of product to assign to the product object,
     *                 will be added to the database if not existing yet
     */
    @Override
    public void addProductWithCategory(Product product, Category category) {

        if(category.getId() != null) {
            product.setCategory(category); // either we set the category if it actually exists in the DB
        } else {
            this.categoryRepository.save(category); // or we create a new one based the value received
        }
        this.productRepository.save(product);
    }

    /**
     * Get all products available
     * @return the full list of products
     */
    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> getProductsByLabel(String label) {
        return productRepository.findByLabel(label);
    }

    @Override
    public List<Product> getProductsByCategory(Category category) {
        return productRepository.findByCategory(category);
    }


    @Override
    public List<Product> getProductsByDescription(String description) {
        return productRepository.findByDescription(description);
    }

    /**
     * Get a product's infos using its unique id
     * @param id database's unique id for a catalog's product
     * @return Optional<Product> the product corresponding to this unique id (empty if product not found)
     */
    @Override
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    /**
     * Update one product using its unique id
     * @param product the product object to be updated
     * @param id database's unique id for a catalog's product
     */
    @Override
    public void updateProductById(Product product, Long id) {
        if(productRepository.existsById(id)) {
            // Does update only if the original data exists...
            Product productToUpdate = productRepository.getReferenceById(id);

            productToUpdate.setLabel(product.getLabel());
            productToUpdate.setDescription(product.getDescription());
            productToUpdate.setCategory(product.getCategory());
            productToUpdate.setUnitPriceHt(product.getUnitPriceHt());
            productToUpdate.setMinOrderQuantity(product.getMinOrderQuantity());
            productToUpdate.setImageResourceUrl(product.getImageResourceUrl());
            productToUpdate.setIsVisible(product.getIsVisible());

            productRepository.save(productToUpdate);

        } else {
            /* Does nothing if the original data doesn't exist,
                but Http response will still be Ok (code = 200)
                TODO: check if it is the correct behavior.
                Otherwise, try to return the correct Http code (204 = content does not exists ?)

            */
        }
    }

    @Override
    public void updateProduct(Product product, Long id) {
        updateProductById(product, id);
    }

    /**
     * Delete a product from the database (Careful : permanent operation)
     * @param id database's unique id for a catalog's product
     */
    @Override
    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public void deleteProduct(Long id) {
        deleteProductById(id);
    }
}
