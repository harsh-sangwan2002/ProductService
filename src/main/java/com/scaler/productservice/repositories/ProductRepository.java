package com.scaler.productservice.repositories;

import com.scaler.productservice.models.Category;
import com.scaler.productservice.models.Product;
import com.scaler.productservice.projections.ProductWithTitleAndPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    // select * from products where id = productId;
    @Override
    Optional<Product> findById(Long productId);

    // select * from products;
    @Override
    List<Product> findAll();

    @Override
    Product save(Product product);

    @Override
    void deleteById(Long id);

    // SQL -> Native Query
    // HQL -> Hibernate Query Language
    // Based on the models
    // select title, price from products where id = 10;
    @Query(value = "select p.title, p.price from products p where p.title = :title and p.price = :price", nativeQuery = true)
    List<ProductWithTitleAndPrice> getProductWithTitleAndPriceSQL(String title, Double price);

    // select * from products where title like '%str%';
    Optional<Product> findByTitleContains(String title);

    Optional<Product> findByCategory(Category category);

    Optional<Product> findByCategory_Id(Long categoryId);
}
