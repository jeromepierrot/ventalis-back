package com.jpierrot.ventalismproducts.database;

import com.jpierrot.ventalismproducts.pojo.Category;
import com.jpierrot.ventalismproducts.pojo.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByLabel(String label);

    // TODO : not fully implemented yet
    List<Product> findByDescription(String description);

    // TODO : not fully implemented yet
    List<Product> findByCategory(Category category);

    // TODO : not fully implemented yet
    List<Product> findByCreatedDate(Date createdDate);

    // TODO : not fully implemented yet
    List<Product> findByModifiedDate(Date modifiedDate);

}
