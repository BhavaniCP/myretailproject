package com.myretail.repository;

import com.myretail.model.CurrentPrice;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrentPriceRepository extends CrudRepository<CurrentPrice, Long> {
}
