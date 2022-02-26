package com.revature.controllers;

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

@CrossOrigin
@RestController
public class ShopProductController {
    @Autowired
    private ShopProductService sps;

    @GetMapping("/shopproducts/{id}")
    public ResponseEntity<ShopProduct> getShopProductByShopId(@PathVariable ("id") String id) {
        ShopProduct sp = sps.getShopProductByShopId(Integer.parseInt(id));

        if(sp != null) {
          return new ResponseEntity<ShopProduct>(sp, HttpStatus.OK);
        }else {
            return new ResponseEntity<ShopProduct>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/shopproducts")
    public List<ShopProduct> getAllShopProducts() {
        return sps.getAllShopProducts;
    }


}
