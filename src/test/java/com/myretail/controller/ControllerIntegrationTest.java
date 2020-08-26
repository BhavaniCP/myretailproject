package com.myretail.controller;

import com.myretail.model.CurrentPrice;
import com.myretail.model.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import java.net.URI;
import java.net.URISyntaxException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ControllerIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testProductNameController() {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/products/10001/name",
                String.class)).contains("The Big Lebowski (Blu-ray)(Widescreen)");
    }

    @Test
    public void testProductPriceController() throws URISyntaxException {
        String baseUrl = "http://localhost:" + port + "/products/10001/price";
        URI uri = new URI(baseUrl);
        ResponseEntity<CurrentPrice> response = restTemplate.getForEntity(uri, CurrentPrice.class);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(10001, response.getBody().getId());
        assertEquals(13.49f, response.getBody().getValue());
        assertEquals("USD", response.getBody().getCurrencyCode());
    }

    @Test
    public void testProductController() throws URISyntaxException {
        String baseUrl = "http://localhost:" + port + "/products/10001";
        URI uri = new URI(baseUrl);
        ResponseEntity<Product> response = restTemplate.getForEntity(uri, Product.class);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(10001, response.getBody().getId());
        assertEquals("The Big Lebowski (Blu-ray)(Widescreen)", response.getBody().getName());
        assertEquals("USD", response.getBody().getCurrentPrice().getCurrencyCode());
    }
}
