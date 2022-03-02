package com.revature.services;

import com.revature.models.ShopProduct;

import java.util.List;
import java.util.Optional;

public interface ShopProductService {

    public Optional<ShopProduct> getShopProductByShopId(int id);
    public List<ShopProduct> getAllShopProducts();

}
