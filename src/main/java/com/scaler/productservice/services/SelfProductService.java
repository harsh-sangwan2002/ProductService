package com.scaler.productservice.services;

import com.scaler.productservice.exceptions.ProductNotFoundException;
import com.scaler.productservice.models.Product;

import java.util.List;

public class SelfProductService implements ProductService{

    @Override
    public Product getProductById(Long productId) throws ProductNotFoundException {
        // Make a call to the db to get the product with the given id
        // select * from products where id = ?
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }
}
