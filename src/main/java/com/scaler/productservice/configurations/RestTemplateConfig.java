package com.scaler.productservice.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    // Create a Bean of RestTemplate
    @Bean
    public RestTemplate createRestTemplate() {
        return new RestTemplate();
    }
}
