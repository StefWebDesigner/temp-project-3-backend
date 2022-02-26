package com.revature.controllers;

import com.revature.models.Product;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@AutoConfigureMockMvc
@SpringBootTest(classes = com.revature.dartcart.DartCartApplication.class)
public class ProductControllersTests {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private ProductService ps;

    @Test
    public void testGetProductById() throws Exception {
        Mockito.when(ps.getProductById(1).thenReturn(new Product(1, "testProduct", "testDescription")));
        ResultActions ra = mvc.perform(MockMvcRequestBuilders.get("/products/1"));
        ra.andExpect(MockMvcResultMatchers.status().isOk());

        Mockito.when(ps.getProductById(3).thenReturn(null));
        ra = mvc.perform(MockMvcRequestBuilders.get("/products/3"));
        ra.andExpect(MockMvcResultMatchers.status().isNotFound());
    }

}
