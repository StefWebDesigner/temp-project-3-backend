package com.revature.services;

import com.revature.models.Product;
import com.revature.models.Seller;
import com.revature.models.Shop;
import com.revature.models.ShopProduct;
import com.revature.repositories.ProductRepo;
import com.revature.repositories.ShopProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ShopProductServiceImpl implements ShopProductService {
    @Autowired
    ShopProductRepo shopProductRepository;

    @Autowired
    ProductRepo pr;

    @Override
    public List<ShopProduct> getAllShopProducts() {
        return (List<ShopProduct>) shopProductRepository.findAll();
    }

    @Override
    public Optional<ShopProduct> getShopProductById(int id) {

        return shopProductRepository.findById(id);
    }

    @Override
    public List<ShopProduct> getSellersForProduct(int id) {
        return shopProductRepository.findByProduct(shopProductRepository.findById(id).get().getProduct());

        /*
        ArrayList<Shop> shops = new ArrayList<>();

        for(ShopProduct s:allListings)
        {
            shops.add(s.getShop());
        }
        return shops;
        */
    }
}
