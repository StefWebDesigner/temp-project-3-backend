package com.revature.integrations.services;

import com.revature.models.Product;
import com.revature.models.Shop;
import com.revature.models.ShopProduct;
import com.revature.repositories.ShopProductRepo;
import com.revature.services.ShopProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class ShopProductServicesTests {

    @Autowired
    ShopProductService sps;

    @Autowired
    ShopProductRepo spr;

    @Test
    void getShopProductByShopProductId() {
        Shop Shop = new Shop();
        Product Product = new Product();

        ShopProduct sp = new ShopProduct(1, 2, 3, 4, Shop, Product);
        Optional<ShopProduct> shopProductOptional = Optional.of(sp);

        Mockito.when(spr.findById(sp.getId())).thenReturn(shopProductOptional);
        Optional<ShopProduct> actual = sps.getShopProductByShopId(sp.getId());
        Assertions.assertEquals(sp.getId(), actual.get().getId());
    }
    @Test
    void getAllShopProducts() {
        Shop Shop = new Shop();
        Product Product = new Product();
        ShopProduct sp = new ShopProduct(2,4,5,6, Shop, Product);
        
    }

}
