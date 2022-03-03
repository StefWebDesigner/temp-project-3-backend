package com.revature.services;

import com.revature.models.CartItem;
import com.revature.models.ShopProduct;
import com.revature.repositories.CartItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartItemServiceImp implements CartItemService{
    @Autowired
    CartItemRepo cir;

    @Override
    public List<CartItem> getAllCartItem() {
        return (List<CartItem>) cir.findAll();
    }

    @Override
    public List<CartItem> getAllCartItem(int userId) {
        return cir.getAllCartItem(userId);
    }

    @Override
    public CartItem addCartItem(CartItem cartItem) {
        return cir.save(cartItem);
    }

    @Override
    public CartItem updateCartItem(CartItem change) {
        return cir.save(change);
    }

    @Override
    public CartItem getCurrentCartbyId(int userId) {
        return cir.getCurrentCart(userId);
    }

//    @Override
//    public boolean deleteCartItem(int id) {
//        try {
//            cir.deleteById(id);
//            return true;
//        } catch (IllegalArgumentException | EmptyResultDataAccessException e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
}
