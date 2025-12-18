package com.scaler.productservice.controllers;

import com.scaler.productservice.models.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return null;
    }

    @GetMapping()
    public List<Product> getAllProducts() {
        return null;
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return null;
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
    public Product deleteProduct(@PathVariable Long id) {
        return null;
    }
}
