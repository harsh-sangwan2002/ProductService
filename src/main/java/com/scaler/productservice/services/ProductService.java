package com.scaler.productservice.services;

import com.scaler.productservice.exceptions.ProductNotFoundException;
import com.scaler.productservice.models.Product;
import com.scaler.productservice.projections.ProductWithTitleAndPrice;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {

    ResponseEntity<Product> getProductById(Long id) throws ProductNotFoundException;
    ResponseEntity<List<Product>> getAllProducts();
    Product createProduct(Product product);
    Product replaceProduct(Long id, Product product) throws ProductNotFoundException;
    void deleteProductById(Long id) throws ProductNotFoundException;
}
