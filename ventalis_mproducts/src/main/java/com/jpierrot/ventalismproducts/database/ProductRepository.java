package com.jpierrot.ventalismproducts.database;

import com.jpierrot.ventalismproducts.pojo.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByLabel(String label);

    // TODO : not fully implemented yet
//    List<Product> findProductsByDescription(String description);

    // TODO : not fully implemented yet
//    List<Product> findProductsByCategory(Category category);

    // TODO : not fully implemented yet
//    List<Product> findProductsByCreationDate(Date createdDate);

    // TODO : not fully implemented yet
//    List<Product> findProductsByModificationDate(Date modifiedDate);

}
