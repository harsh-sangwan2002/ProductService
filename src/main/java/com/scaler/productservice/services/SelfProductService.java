package com.scaler.productservice.services;

import com.scaler.productservice.exceptions.ProductNotFoundException;
import com.scaler.productservice.models.Product;
import com.scaler.productservice.repositories.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("selfProductService")
public class SelfProductService implements ProductService {

    private final ProductRepository productRepository;

    public SelfProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ResponseEntity<Product> getProductById(Long id) throws ProductNotFoundException {
        // Make a db call to get the product with given id
        Optional<Product> product = productRepository.findById(id);

        if(product.isEmpty()){
            throw new ProductNotFoundException("Cannot find product with given id.");
        }

        return new ResponseEntity<>(product.get(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Product>> getAllProducts() {

        List<Product> products = productRepository.findAll();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}
