package com.scaler.productservice.repositories;

import com.scaler.productservice.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    // select * from categories where name = categoryName
    Optional<Category> findByName(String categoryName);

    Category save(Category category);
}
