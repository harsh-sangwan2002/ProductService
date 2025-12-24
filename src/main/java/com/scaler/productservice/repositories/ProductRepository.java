package com.scaler.productservice.repositories;

import com.scaler.productservice.models.Category;
import com.scaler.productservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    @Override
    Product save(Product product);

    @Override
    Optional<Product> findById(Long productId);
    // select * from products where id = productId

    @Override
    List<Product> findAll();

    Optional<Product> findByTitleContains(String title);

    Optional<Product> findByCategory(Category category);

    Optional<Product> findByCategory_Id(Long categoryId);

    @Override
    void deleteById(Long id);
}
