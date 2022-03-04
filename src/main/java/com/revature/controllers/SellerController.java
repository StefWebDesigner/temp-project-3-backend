package com.revature.controllers;

import com.revature.models.Seller;
import com.revature.models.ShopProduct;
import com.revature.services.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class SellerController {

    @Autowired
    SellerService sellerService;

//    @GetMapping("/shop_products/{id}")
//    public ResponseEntity<List<Seller>> getSellerById(@PathVariable("id") String id) {
//        Optional<Seller> sp = sellerService.getSellerById(Integer.parseInt(id));
//        return ResponseEntity.of(sp);
//
//    }

//    @GetMapping("/sellers")
//    public List<Seller> getAllShopProducts() {
//        return sellerService.getAllShopProducts();
//    }



}
