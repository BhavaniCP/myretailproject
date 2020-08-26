package com.myretail.controller;

import com.myretail.exceptions.ProductNameNotFoundException;
import com.myretail.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductNameController {

    @Autowired
    private ProductService productService;

    @GetMapping("/{productId}/name")
    public String getProductName(@PathVariable Long productId) throws ProductNameNotFoundException {
        if (!productService.getProduct(productId).isPresent()) {
            throw new ProductNameNotFoundException("product name with id " + productId + " is not found");
        }
        return productService.getProduct(productId).get().getName();
    }
}
