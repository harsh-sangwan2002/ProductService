package com.scaler.productservice.services;

import com.scaler.productservice.dtos.FakeStoreProductDto;
import com.scaler.productservice.exceptions.ProductNotFoundException;
import com.scaler.productservice.models.Category;
import com.scaler.productservice.models.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService {
    // This service implementation uses FakeStore to fetch products from FakeStore API.
    private RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private Product convertFakeStoreDtoProductToProduct(FakeStoreProductDto fakeStoreProductDto) {
        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setDescription(fakeStoreProductDto.getDescription());

        Category category = new Category();
        category.setName(fakeStoreProductDto.getCategory());
        product.setCategory(category);

        return product;
    }

    @Override
    public ResponseEntity<Product> getProductById(Long id) throws ProductNotFoundException {
        // Make an API call to FakeStore to get the product with the given id.
        FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject(
                "https://fakestoreapi.com/products/" + id,
                FakeStoreProductDto.class);

        if(fakeStoreProductDto==null){
            throw new ProductNotFoundException("Cannot find product with given id.");
        }

        Product product = convertFakeStoreDtoProductToProduct(fakeStoreProductDto);
        return new ResponseEntity<>(
                product, HttpStatus.OK
        );
    }

    @Override
    public ResponseEntity<List<Product>> getAllProducts() {
        // List<FakeStoreProductDto>.class is not available at run-time due to type-erasure property of Java.
        // So we need to do it inside the array
        FakeStoreProductDto[] fakeStoreProductDtos = restTemplate.getForObject(
                "https://fakestoreapi.com/products/",
                FakeStoreProductDto[].class
        );
        List<Product> products = new ArrayList<>();

        for(FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos) {
            products.add(convertFakeStoreDtoProductToProduct(fakeStoreProductDto));
        }

        return  new ResponseEntity<>(
                products, HttpStatus.OK
        );
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public Product replaceProduct(Long id, Product product) {
        return null;
    }

    @Override
    public void deleteProductById(Long id) throws ProductNotFoundException {

    }
}
