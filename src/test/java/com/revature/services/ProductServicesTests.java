package com.revature.services;

import com.revature.models.Category;
import com.revature.models.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

@SpringBootTest
public class ProductServicesTests {
    @Autowired
    ProductService productService;

    @MockBean
    private ProductRepository productRepository;


    @Test
    public void testGetProductById() {

    }

    @Test
    public void testGetAllProducts() {

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
