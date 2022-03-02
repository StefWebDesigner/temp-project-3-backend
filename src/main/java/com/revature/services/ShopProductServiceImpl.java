package com.revature.services;

import com.revature.models.ShopProduct;
import com.revature.repositories.ShopProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShopProductServiceImpl implements ShopProductService{
@Autowired
private ShopProductRepo spr;
    @Override
    public Optional<ShopProduct> getShopProductByShopId(int id) {
        return spr.findById(id);
    }

    @Override
    public List<ShopProduct> getAllShopProducts() {
        return (List<ShopProduct>) spr.findAll();
    }
}
