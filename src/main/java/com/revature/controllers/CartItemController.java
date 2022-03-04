package com.revature.controllers;

import com.revature.models.CartItem;
import com.revature.repositories.UserRepo;
import com.revature.services.CartItemService;
import com.revature.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class CartItemController {
    @Autowired
    CartItemService cis;
    @Autowired
    UserServiceImpl userService;

    @GetMapping("/carts")
    public List<CartItem> getAllCartItem() {
        return cis.getAllCartItem();
    }

    @GetMapping("/carts/{username}")
    public List<CartItem> getAllCartItem(@PathVariable("username") String username) {
        return cis.getAllCartItem(userService.getUserByUsername(username).getId());
    }

    @PostMapping(value = "/carts")
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
