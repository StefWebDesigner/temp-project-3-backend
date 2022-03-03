package com.revature.controllers;

import com.revature.models.CartItem;
import com.revature.services.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class CartItemController {
    @Autowired
    CartItemService cis;

    @GetMapping("/carts")
    public List<CartItem> getAllCartItem() {
        return cis.getAllCartItem();
    }

    @GetMapping("/carts/{userId}")
    public List<CartItem> getAllCartItem(@PathVariable("userId") String userId) {
        return cis.getAllCartItem(Integer.parseInt("userId"));
    }

    @PostMapping(value = "/carts", consumes = "application/json", produces = "application/json")
    public CartItem addCartItem(@RequestBody CartItem cartItem) {
        return cis.addCartItem(cartItem);
    }

//    @PutMapping(value="/carts/{id}", consumes = "application/json", produces = "application/json")
//    public CartItem updateCartItem(@PathVariable("id") String id, @RequestBody int quantity) {
//        //change.setId(Integer.parseInt(id));
//        if(quantity == 0){
//            //cis.deleteCartItem(id);
//        }
//        CartItem ci = cis.getCurrentCartbyId(Integer.parseInt(id));
//        ci.setQuantity(quantity);
//        return cis.updateCartItem(ci);
//    }
}
