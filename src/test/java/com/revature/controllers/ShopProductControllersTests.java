package com.revature.controllers;

import com.revature.models.ShopProduct;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

public class ShopProductControllersTests {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ShopProductService sps;

    @Test
    void getShop_ProductsbyId() throws Exception {

        Mockito.when(sps.getShopProductById(1).thenReturn(new ShopProduct(1, 1, 10, 15.99, 2.99)));
        ResultActions ra = mvc.perform(MockMvcRequestBuilders.get("/Shop_products/1"));
        ra.andExpect(MockMvcResultMatchers.status().isOk());

        Mockito.when(sps.getProductById(2).thenReturn(null));
        ra = mvc.perform(MockMvcRequestBuilders.get("/Shop_products/2"));
        ra.andExpect(MockMvcResultMatchers.status().isNotFound());


    }


}
