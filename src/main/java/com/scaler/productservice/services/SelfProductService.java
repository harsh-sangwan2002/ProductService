package com.scaler.productservice.services;

import com.scaler.productservice.exceptions.ProductNotFoundException;
import com.scaler.productservice.models.Category;
import com.scaler.productservice.models.Product;
import com.scaler.productservice.repositories.CategoryRepository;
import com.scaler.productservice.repositories.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("selfProductService")
public class SelfProductService implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public SelfProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
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

    @Override
    public Product createProduct(Product product) {
        Category category = product.getCategory();
        // Before saving the product in the db, we should first check if the category is present in db or not

        Optional<Category> categoryOptional = categoryRepository.findByName(category.getName());

        if(categoryOptional.isEmpty()){
            Category savedCategory = categoryRepository.save(category);
            product.setCategory(savedCategory);
        }else{
            product.setCategory(categoryOptional.get());
        }

        return productRepository.save(product);
    }

    @Override
    public Product replaceProduct(Long id, Product product) throws ProductNotFoundException {
        Optional<Product> optionalProduct = productRepository.findById(id);

        if(optionalProduct.isEmpty()){
            throw new ProductNotFoundException("Product with the given id is not present.");
        }

        Product productFromDB = optionalProduct.get();
        productFromDB.setPrice(product.getPrice());
        productFromDB.setTitle(product.getTitle());
        productFromDB.setImageUrl(product.getImageUrl());
        productFromDB.setDescription(product.getDescription());

        Category category = product.getCategory();
        if(category.getId()==null){
            category = categoryRepository.save(category);
        }
        productFromDB.setCategory(category);

        return productRepository.save(productFromDB);
    }

    @Override
    public void deleteProductById(Long id) throws ProductNotFoundException {
        productRepository.deleteById(id);
    }
}
