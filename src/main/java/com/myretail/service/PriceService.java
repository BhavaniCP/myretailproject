package com.myretail.service;

import com.myretail.model.CurrentPrice;
import com.myretail.repository.CurrentPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PriceService {

    @Autowired
    private CurrentPriceRepository priceRepository;

    public CurrentPrice getProduct(Long productId) {
        return priceRepository.findById(productId).get();
    }
}
