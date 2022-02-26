package com.revature.integrations;

import com.revature.models.Product;
import com.revature.services.ProductServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = com.revature.dartcart.DartCartApplication.class)
@Transactional
public class ProductServiceIntegrationTest {
    @Autowired
    private ProductServiceImpl ps;

    @Test
    public void testGetProductById() {
        Optional<Product> p = ps.getProductById(1);
        assertTrue(p.isPresent());

        assertEquals(p.get().getId(), 1);
        assertNotEquals(p.get().getId(), 5);

        assertEquals(p.get().getName(), "Kelloggs Froot Loops");
        assertNotEquals(p.get().getName(), "failData");

        assertEquals(p.get().getDescription(), "Delicious frooty flava");
        assertNotEquals(p.get().getDescription(), "failData");
    }
}
