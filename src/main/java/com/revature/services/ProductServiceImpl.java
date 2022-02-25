package com.revature.services;

import com.revature.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    ProductRepo pr;

    @Override
    public Product getProductById(int productId) {
        Optional<Product> product = pr.findById(productId);
        return product.orElseGet(Product::new);
    }

}
