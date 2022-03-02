package com.revature.services;

import com.revature.models.ShopProduct;
import com.revature.repositories.ShopProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShopProductServiceImpl implements ShopProductService {
    @Autowired
    ShopProductRepository shopProductRepository;

    @Override
    public List<ShopProduct> gelAllShopProducts() {
        return (List<ShopProduct>) shopProductRepository.findAll();
    }

    @Override
    public Optional<ShopProduct> getShopProductById(int id) {

        return shopProductRepository.findById(id);
    }
}
