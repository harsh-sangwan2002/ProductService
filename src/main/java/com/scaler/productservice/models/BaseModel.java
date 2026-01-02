package com.scaler.productservice.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment the id
    private Long id;
}

// MappedSuperClass - No table for BaseModel class but all the attributes of BaseModel will be present in the child classes.
