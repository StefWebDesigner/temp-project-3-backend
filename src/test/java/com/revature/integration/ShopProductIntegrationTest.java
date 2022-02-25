package com.revature.integration;


import com.revature.models.ShopProduct;
import com.revature.repositories.ShopProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@SpringBootTest(classes = com.revature.dartcart.DartCartApplication.class)
@Transactional
public class ShopProductIntegrationTest {

    @Autowired
    private ShopProductRepository shopProductRepository;


    @Test
    void getAllShopProduct() {

        List<ShopProduct> allShopProducts = (List<ShopProduct>) shopProductRepository.findAll();

        Assertions.assertNotNull(allShopProducts);

    }

    @Test
    void getShopProductById() {

        Optional<ShopProduct> shopProduct = shopProductRepository.findById(1);
        Assertions.assertEquals("Frooty Loops", shopProduct.get().getProduct().getName());
        Assertions.assertEquals(1, shopProduct.get().getProduct().getId());
        Assertions.assertEquals(10, shopProduct.get().getQuantity());
        Assertions.assertEquals(15.99, shopProduct.get().getPrice());
    }

    @Test
    void getDiscountedShopProducts() {

        List<ShopProduct> shopProducts = (List<ShopProduct>) shopProductRepository.findAll();
        shopProducts.stream().filter(shopProduct -> shopProduct.getDiscount() > 0)
                .collect(Collectors.toList());

        Assertions.assertNotNull(shopProducts);
    }


}
