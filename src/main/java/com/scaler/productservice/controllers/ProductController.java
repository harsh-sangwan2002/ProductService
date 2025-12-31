package com.scaler.productservice.controllers;

import com.scaler.productservice.exceptions.ProductNotFoundException;
import com.scaler.productservice.models.Product;
import com.scaler.productservice.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Long id) throws ProductNotFoundException {
        return productService.getProductById(id);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
        return null;
    }

    @PatchMapping("/{id}")
    public Product patchProduct(@PathVariable Long id, @RequestBody Product product) {
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {

    }
}
