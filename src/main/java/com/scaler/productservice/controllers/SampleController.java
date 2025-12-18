package com.scaler.productservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // REST + Controller ==> HTTP APIs + Controller
@RequestMapping("/random")
public class SampleController {

    @GetMapping("/hello/{numberOfTimes}")
    public String sayHello(@PathVariable int numberOfTimes){
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<numberOfTimes;i++){
            sb.append("Hello World! ");
        }

        return sb.toString();
    }

    @GetMapping("/bye")
    public String sayBye(){
        return "Bye";
    }
}

/*
Endpoint - /orders, /search, /products
https://www.amazon.com/search?q='iPhone'
*/