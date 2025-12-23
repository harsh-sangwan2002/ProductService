package com.scaler.productservice.inheritanceDemo.mappedsuperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "msc_instructors")
public class Instructor extends User {

    private String specialization;
    private Double averageRating;
}
