package com.revature.services;

import com.revature.models.ShopProduct;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

public class ShopProductServicesTests {


    @Autowired
    private ShopProductService ShopProductService;

    @MockBean
    private ShopProductRepository shopProductRepository;

    @Test
    void getShop_ProductById(int id) {

        ShopProduct product = shopProductService.getShopProductById(id);

        assertNotNull(product);
        assertNotEquals(0, product.getQuantity());
        assertNotEquals(0, product.getDiscount());
        assertNotEquals(0, product.getPrice());
        assertNotEquals(0, product.getId());
        assertEquals(10, product.getQuantity());
        assertEquals(15.99, product.getQuantity());
        assertEquals(2.99, product.getQuantity());

    }

}
