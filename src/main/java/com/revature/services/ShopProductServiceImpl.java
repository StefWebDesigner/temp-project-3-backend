package com.revature.services;

import com.revature.models.ShopProduct;
import com.revature.repositories.ShopProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ShopProductServiceImpl implements ShopProductService {
    @Autowired
    ShopProductRepo shopProductRepo;

    @Override
    public List<ShopProduct> getAllShopProducts() {
        return (List<ShopProduct>) shopProductRepo.findAll();
    }

    @Override
    public Optional<ShopProduct> getShopProductById(int id) {

        return shopProductRepo.findById(id);
    }

    @Override
    public List<ShopProduct> searchByProductName(String searchString) {
        List<ShopProduct> shopProductList = (List<ShopProduct>) shopProductRepository.findAll();
        return shopProductList.stream().filter(shopProduct ->
                shopProduct.getProduct().getName().toLowerCase().contains(searchString.toLowerCase())).collect(Collectors.toList());
    }
}
