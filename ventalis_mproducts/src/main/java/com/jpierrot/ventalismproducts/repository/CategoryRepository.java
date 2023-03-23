package com.jpierrot.ventalismproducts.repository;

import com.jpierrot.ventalismproducts.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    // TODO : not fully implemented yet
    List<Category> findByName(String name);

    // TODO : not fully implemented yet
//    List<Category> findCategoryByCreationDate(Date createdDate);

    // TODO : not fully implemented yet
//    List<Category> findCategoryByModificationDate(Date modifiedDate);
}
