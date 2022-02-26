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
        Optional<Product> product = ps.getProductById(1);
        Product p = product.get();

        assertEquals(p.getId(), 1);
        assertNotEquals(p.getId(), 5);

        assertEquals(p.getName(), "Kelloggs Froot Loops");
        assertNotEquals(p.getName(), "failData");

        assertEquals(p.getDescription(), "Delicious frooty flava");
        assertNotEquals(p.getDescription(), "failData");
    }
}
