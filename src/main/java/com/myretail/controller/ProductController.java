package com.myretail.controller;

import com.myretail.model.CurrentPrice;
import com.myretail.model.Product;
import com.myretail.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.math.BigInteger;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ProductService productService;

    @Value("${product.name.api.endpoint}")
    private String nameApiEndpoint;

    @Value("${product.price.api.endpoint}")
    private String priceApiEndpoint;

    @GetMapping("/{id}")
    public Product findProduct(@PathVariable("id") Long id) {
        String productName = restTemplate.getForObject(nameApiEndpoint, String.class, id);
        CurrentPrice price = restTemplate.getForObject(priceApiEndpoint, CurrentPrice.class, id);
        return new Product(id, productName, price);
    }

    @PostMapping("/{id}")
    public BigInteger updateProduct(@PathVariable BigInteger id, @RequestBody Product product) {
        productService.update(product);
        return id;
    }

}
