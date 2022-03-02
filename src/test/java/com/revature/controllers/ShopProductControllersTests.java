package com.revature.controllers;

import com.revature.dartcart.DartCartApplication;
import com.revature.models.Category;
import com.revature.models.Product;
import com.revature.models.ShopProduct;
import com.revature.services.ShopProductServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = DartCartApplication.class)
public class ShopProductControllersTests {
    @Autowired
    private MockMvc mvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @MockBean
    private ShopProductServiceImpl sps;

    @BeforeEach
    void setup(){
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    final static ShopProduct testShopProduct = new ShopProduct(
            1,
            new Product(1,
                    "testProduct",
                    "testDescription",
                    new ArrayList<Category>(Arrays.asList(new Category(1, "testCategory")))),
            20,
            50.0,
            0.0
    );

    @Test
    void getShopProductByIdPass() throws Exception {
        Mockito.when(sps.getShopProductById(1)).thenReturn(Optional.of(testShopProduct));
        ResultActions ra = mvc.perform(MockMvcRequestBuilders.get("/shop_products/1"));
        ra.andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void getShopProductByIdFail() throws Exception {
        Mockito.when(sps.getShopProductById(2)).thenReturn(Optional.empty());
        ResultActions ra = mvc.perform(MockMvcRequestBuilders.get("/shop_products/2"));
        ra.andExpect(MockMvcResultMatchers.status().isNotFound());
    }
}
