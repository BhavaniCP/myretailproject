package com.myretail.service;

import com.myretail.model.Product;
import com.myretail.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Optional<Product> getProduct(Long productId) {
        return productRepository.findById(productId);
    }

    public Long update(Product product) {
        productRepository.save(product);
        return product.getId();
    }
}
