package com.myretail.controller;

import com.myretail.model.CurrentPrice;
import com.myretail.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductPriceController {

    @Autowired
    private PriceService priceService;

    @GetMapping("/{productId}/price")
    public CurrentPrice getCurrentPrice(@PathVariable Long productId) {
        return priceService.getProduct(productId);
    }
}
