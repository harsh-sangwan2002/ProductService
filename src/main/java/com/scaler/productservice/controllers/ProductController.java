package com.scaler.productservice.controllers;

import com.scaler.productservice.models.Product;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @GetMapping
    public List<Product> getProducts() {
        return new ArrayList<>();
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Long id) {
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
    public void deleteProduct(@PathVariable Long id) {

    }
}
