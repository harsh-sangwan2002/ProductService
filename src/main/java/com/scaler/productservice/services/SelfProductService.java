package com.scaler.productservice.services;

import com.scaler.productservice.exceptions.ProductNotFoundException;
import com.scaler.productservice.models.Product;
import com.scaler.productservice.repositories.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("selfProductService")
//@Primary
public class SelfProductService implements ProductService{

    private ProductRepository productRepository;

    public SelfProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product getProductById(Long productId) throws ProductNotFoundException {
        // Make a call to the db to get the product with the given id
        // select * from products where id = ?
        Optional<Product> optionalProduct = productRepository.findById(productId);

        if(optionalProduct.isEmpty()){
            throw new ProductNotFoundException("Product not found");
        }

        return optionalProduct.get();
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }
}
