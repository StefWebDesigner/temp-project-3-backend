package com.revature.controllers;

import com.revature.models.Category;
import com.revature.models.Product;
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
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ShopProductControllersTests {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ShopProductService sps;

    @Test
    void getShopProductByIdPass() throws Exception {
        Mockito.when(sps.getShopProductById(1).thenReturn(Optional.of(testShopProduct)));
        ResultActions ra = mvc.perform(MockMvcRequestBuilders.get("/shop_products/1"));
        ra.andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void getShopProductByIdFail() throws Exception {
        Mockito.when(sps.getProductById(2).thenReturn(Optional.empty()));
        ResultActions ra = mvc.perform(MockMvcRequestBuilders.get("/shop_products/2"));
        ra.andExpect(MockMvcResultMatchers.status().isNotFound());
    }
}
