package com.scaler.productservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // HTTP APIs + Controller
@RequestMapping("/random")
public class SampleController {

    // http://localhost:8080/random/hello
    @GetMapping("/hello/{numberOfTimes}")
    public String hello(@PathVariable int numberOfTimes){
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < numberOfTimes; i++){
            sb.append("Hello World! ");
        }

        return sb.toString();
    }

    @GetMapping("/bye")
    public String bye(){
        return "Bye";
    }
}

/*
http -> default port = 80
https -> default port = 443

Endpoints - /orders, /search, /products
https://www.amazon.com/search?q='iPhone'
*/
