package com.revature.controllers;

import com.revature.models.ShopProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Id;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class ShopProductController {
    @Autowired
    private ShopProductService sps;

    @GetMapping("/shop-products/{id}")
    public ResponseEntity<ShopProduct> getShopProductByShopId(@PathVariable ("id") String id) {
        Optional<ShopProduct> sp = sps.getShopProductByShopId(Integer.parseInt(id));
        return ResponseEntity.of(sp);

    }

    @GetMapping("/shop-products")
    public List<ShopProduct> getAllShopProducts() {
        return sps.getAllShopProducts();
    }


}
