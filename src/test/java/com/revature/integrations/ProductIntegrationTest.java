package com.revature.integrations;

import com.revature.models.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = com.revature.dartcart.DartCartApplication.class)
@Transactional
public class ProductIntegrationTest {
    @Autowired
    private ProductRepository pr;

    @Test
    public void findProductById() {
        Optional<Product> product = pr.findById(1);

        assertTrue(product.isPresent());

        Product p = product.get();

        assertEquals(p.getId(), 1);
        assertEquals(p.getName(), "Kelloggs Froot Loops");
        assertEquals(p.getDescription(), "Delicious frooty flava");
        assertEquals(p.getCategory().size(), 1);
    }
}
