package com.revature.integrations;

import com.revature.models.Product;
import com.revature.services.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest(classes = com.revature.dartcart.DartCartApplication.class)
@Transactional
public class ProductServiceIntegrationTest {
    @Autowired
    private ProductService ps;

    @Test
    public void testGetProductById() {
        Optional<Product> productOptional = ps.getProductById(1);
        Product product = productOptional.get();

        assertEquals(product.getId(), 1);
        assertNotEquals(product.getId(), 5);

        assertEquals(product.getName(), "Kelloggs Froot Loops");
        assertNotEquals(product.getName(), "failData");

        assertEquals(product.getDescription(), "Delicious frooty flava");
        assertNotEquals(product.getDescription(), "failData");
    }
}
