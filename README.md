# Product Service – Spring Boot

A minimal Spring Boot REST service that exposes product-related APIs using a controller-based architecture.

---

## Tech Stack
- Java
- Spring Boot
- Spring Web (REST APIs)

---

## Overview
This project demonstrates a simple Product Service built using Spring Boot.  
It focuses on exposing REST endpoints through a controller while keeping the setup minimal and easy to understand.

---

## Features
- RESTful API design
- Product listing endpoint
- Product retrieval by ID
- Lightweight and beginner-friendly structure

---

## API Endpoints

| Method | Endpoint | Description |
|------|---------|-------------|
| GET | `/products` | Retrieve all products |
| GET | `/products/{id}` | Retrieve a product by its ID |

---

## Project Structure
```bash
src/main/java
└── com.example.productservice
├── ProductServiceApplication
└── controller
└── ProductController
```

---

## How to Run
1. Ensure Java and Maven are installed
2. Start the Spring Boot application
3. Access the APIs on `http://localhost:8080`

---

## Use Cases
- Learning Spring Boot REST controllers
- Interview preparation
- Quick backend service prototyping

---

## Notes
- No database integration included
- No service or repository layer
- Designed for simplicity and clarity

---

## Author
Harsh Sangwan