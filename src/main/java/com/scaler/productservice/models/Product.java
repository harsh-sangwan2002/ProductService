package com.scaler.productservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "products")
public class Product extends BaseModel {

    private String title;
    private String description;
    private String imageUrl;
    private int price;

    @ManyToOne
    private Category category;
}

/*
Product --- Category
(M) - (1)
*/
