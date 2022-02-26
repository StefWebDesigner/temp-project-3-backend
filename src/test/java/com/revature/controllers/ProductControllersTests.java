package com.revature.controllers;

import com.revature.dartcart.DartCartApplication;
import com.revature.models.Category;
import com.revature.models.Product;
import com.revature.services.ProductService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers;
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.setup.MockMvcConfigurer;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = DartCartApplication.class)
public class ProductControllersTests {
    @Autowired
    private MockMvc mvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @MockBean
    private ProductService ps;

    @BeforeEach
    void setup(){
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    final static Product testProduct = new Product(
            1,"testProduct",
            "testDescription",
            new ArrayList<Category>(Arrays.asList(new Category(1, "testCategory")))
    );

    @Test
    public void testGetProductByIdSuccess() throws Exception {
        Mockito.when(ps.getProductById(1)).thenReturn(Optional.of(testProduct));
        ResultActions ra = mvc.perform(MockMvcRequestBuilders.get("/products/1"));
        ra.andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testGetProductByIdFail() throws Exception {
        Mockito.when(ps.getProductById(3)).thenReturn(Optional.empty());
        ResultActions ra = mvc.perform(MockMvcRequestBuilders.get("/products/3"));
        ra.andExpect(MockMvcResultMatchers.status().isNotFound());
    }
}
