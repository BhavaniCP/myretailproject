package com.myretail.repository;

import com.myretail.model.CurrentPrice;
import com.myretail.model.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ProductRepositoryIntegrationTest {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    public void shouldNotNull() {
        assertThat(productRepository).isNotNull();
        assertThat(testEntityManager).isNotNull();
    }

    //@Test
    public void testCrud() {
        CurrentPrice price = new CurrentPrice(101L, 34.23f, "USD");
        Product ibmProduct = new Product(101L, "IBM", price);
        testEntityManager.persist(ibmProduct);

        Optional<Product> productFromDB = productRepository.findById(101L);
        assertThat(productFromDB.get()).isNotNull();
        assertEquals("product id should be 101", Optional.of(101L), productFromDB.get().getId());
        assertEquals("Product should be IBM", "IBM", productFromDB.get().getName());

        ibmProduct.setName("IBM private limited");

        productRepository.save(ibmProduct);

        productRepository.deleteById(ibmProduct.getId());
        assertThat(productRepository.findById(ibmProduct.getId())).isNull();

    }


}
