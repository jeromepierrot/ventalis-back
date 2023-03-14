package com.jpierrot.ventalismproducts.database;

import com.jpierrot.ventalismproducts.pojo.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}