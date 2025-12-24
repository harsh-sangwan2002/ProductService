package com.scaler.productservice.services;

import com.scaler.productservice.exceptions.ProductNotFoundException;
import com.scaler.productservice.models.Category;
import com.scaler.productservice.models.Product;
import com.scaler.productservice.repositories.CategoryRepository;
import com.scaler.productservice.repositories.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("selfProductService")
//@Primary
public class SelfProductService implements ProductService{

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    public SelfProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    public Product createProduct(Product product) {
        // Before saving the product in DB, we should first check if category is in the DB or not.
        // If yes, then find else we will have to save the category first in the DB.
        Category category = product.getCategory();
        Optional<Category> optionalCategory = categoryRepository.findByName(category.getName());

        if(optionalCategory.isPresent()) {
            product.setCategory(optionalCategory.get());
        }else{
            categoryRepository.save(category);
            product.setCategory(category);
        }

        return productRepository.save(product);
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
        return productRepository.findAll();
    }

    @Override
    public Product replaceProduct(Long id, Product product) throws ProductNotFoundException {
        Optional<Product> optionalProduct = productRepository.findById(id);

        if(optionalProduct.isEmpty()){
            throw new ProductNotFoundException("No product for this id found");
        }
        Product newProduct = optionalProduct.get();

        newProduct.setTitle(product.getTitle());
        newProduct.setImageUrl(product.getImageUrl());
        newProduct.setPrice(product.getPrice());
        newProduct.setCategory(product.getCategory());

        return productRepository.save(newProduct);
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        return null;
    }

    @Override
    public void deleteProduct(Long id) throws ProductNotFoundException {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isEmpty()){
            throw new ProductNotFoundException("Product not found");
        }

        productRepository.deleteById(id);
    }
}
