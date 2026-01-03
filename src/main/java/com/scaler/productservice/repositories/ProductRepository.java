package com.scaler.productservice.repositories;

import com.scaler.productservice.models.Category;
import com.scaler.productservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    // select * from products where id = productId;
    @Override
    Optional<Product> findById(Long productId);

    // select * from products;
    @Override
    List<Product> findAll();

    // select * from products where title like '%str%';
    Optional<Product> findByTitleContains(String title);

    Optional<Product> findByCategory(Category category);

    Optional<Product> findByCategory_Id(Long categoryId);
}
