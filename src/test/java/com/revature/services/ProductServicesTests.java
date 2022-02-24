package com.revature.services;

import com.revature.models.Category;
import com.revature.models.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.junit.jupiter.api.Assertions.*;


import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class ProductServicesTests {
    @Autowired
    ProductService productService;

    @MockBean
    private ProductRepository productRepository;


    @Test
    public void testGetProductById() {
        Product product = productService.getProductById(1);
        assertEquals(product.getId(), 1);
        assertNotEquals(product.getId(), 0);
        assertEquals(product.getName(), "Kelloggs Froot Loops");
        assertNotEquals(product.getName(), "Kelloggs Frosted Flakes");
        assertEquals(product.getDescription(), "Delicious frooty flava");
        assertNotEquals(product.getDescription(), "Disgusting frooty flava");
    }

    @Test
    public void testGetAllProducts() {
        List<Product> productList = productService.getAllProducts();
        Product product1 = productList.get(0);
        assertEquals(product1.getId(), 1);
        assertNotEquals(product1.getId(), 0);
        assertEquals(product1.getName(), "Kelloggs Froot Loops");
        assertNotEquals(product1.getName(), "Kelloggs Frosted Flakes");
        assertEquals(product1.getDescription(), "Delicious frooty flava");
        assertNotEquals(product1.getDescription(), "Disgusting frooty flava");
    }

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
