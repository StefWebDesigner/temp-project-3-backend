package com.revature.services;

import com.revature.models.Category;
import com.revature.models.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest(classes = com.revature.dartcart.DartCartApplication.class)
public class ProductServicesTests {
    @Autowired
    ProductService productService;

    @MockBean
    private ProductRepo productRepository;


    @Test
    public void testGetProductById() {
        List<Category> categories = new ArrayList<>();
        categories.add(new Category(1, "Food"));
        Product product = new Product(1, "Kelloggs Froot Loops", "Delicious frooty flava", categories);
        when(productRepository.findById(1)).thenReturn(Optional.of(product));
        assertEquals(1, product.getId());
        assertNotEquals(0, product.getId());
        assertEquals("Kelloggs Froot Loops", product.getName());
        assertNotEquals("Kelloggs Frosted Flakes", product.getName());
        assertEquals("Delicious frooty flava", product.getDescription());
        assertNotEquals( "Disgusting frooty flava", product.getDescription());
    }

//    @Test
//    public void testGetAllProducts() {
//        List<Product> productList = productService.getAllProducts();
//        Product product1 = productList.get(0);
//        assertEquals(product1.getId(), 1);
//        assertNotEquals(product1.getId(), 0);
//        assertEquals(product1.getName(), "Kelloggs Froot Loops");
//        assertNotEquals(product1.getName(), "Kelloggs Frosted Flakes");
//        assertEquals(product1.getDescription(), "Delicious frooty flava");
//        assertNotEquals(product1.getDescription(), "Disgusting frooty flava");
//    }

//    @Test
//    public void testSearchByCategory() {
//
//    }
//
//    @Test
//    public void testSearchByWord() {
//
//    }

//    @Test
//    public void testAddProduct() {
//        Product product = new Product();
//        product.setId(1);
//        product.setName("Cocoa Puffs");
//        product.setDescription("I'm coo-coo for Cocoa Puffs");
//
//        Category category1 = new Category();
//        category1.setId(1);
//        category1.setName("Food");
//
//        List<Category> categoriesList = {category1};
//        product.setCategory(categoriesList);
//    }

//    @Test
//    public void testUpdateProduct() {
//
//    }
//
//    @Test
//    public void deleteProduct() {
//
//    }

}
