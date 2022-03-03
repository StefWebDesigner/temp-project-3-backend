package com.revature.repositories;

import com.revature.models.CartItem;
import com.revature.models.ShopProduct;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CartItemRepo extends CrudRepository<CartItem, Integer> {
    
    @Query(value = "SELECT * FROM CartItems WHERE cart_item_id=? AND date IS NOT NULL;", nativeQuery = true)
    List<CartItem> getAllCartItem(int id);

    @Query(value = "SELECT * FROM CartItems WHERE customer_id=? AND date IS NULL;", nativeQuery = true)
    CartItem getCurrentCart(int userId);


    //void deleteByObject(ShopProduct shopProduct);
}
