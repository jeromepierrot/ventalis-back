package com.jpierrot.ventalismproducts.database;

import com.jpierrot.ventalismproducts.pojo.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
