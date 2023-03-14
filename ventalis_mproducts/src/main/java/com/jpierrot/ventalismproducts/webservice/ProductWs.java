package com.jpierrot.ventalismproducts.webservice;

import com.jpierrot.ventalismproducts.api.ApiRouter;
import com.jpierrot.ventalismproducts.controllers.ProductService;
import com.jpierrot.ventalismproducts.pojo.Product;
import com.jpierrot.ventalismproducts.webservice.exceptions.CategoryNotFoundException;
import com.jpierrot.ventalismproducts.webservice.exceptions.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(ApiRouter.REST_CATALOG)
//@CrossOrigin(origins = "http://localhost:4200")
public class ProductWs {
    private static final String ERROR_MESSAGE = "Aucun produit trouvé";

    @Autowired
    private ProductService productService;

    @PostMapping
    public void addProduct(@RequestBody Product product) { productService.addProduct(product); }

    @GetMapping
    public List<Product> getAllProducts() throws ProductNotFoundException {
        List<Product> products = productService.getAllProducts();
        if(products.isEmpty()) throw new ProductNotFoundException(ERROR_MESSAGE);
        return products;
    }

    // TODO/FIX : not working, to be fixed
    @GetMapping("/{id}")
    public Optional<Product> getProductById (@PathVariable Long id) throws ProductNotFoundException {
        Optional<Product> product = productService.getProductById(id);
        if(product.isEmpty()) throw new ProductNotFoundException(ERROR_MESSAGE);

        return product;
    }

    // TODO/FIX : not working, to be fixed
    @PutMapping("/update/{id}")
    public void updateProduct (@RequestBody Product product, @PathVariable Long id) {
        productService.updateProduct(product, id);
    }

    // TODO : to be tested
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {

        productService.deleteProduct(id);
    }

}
