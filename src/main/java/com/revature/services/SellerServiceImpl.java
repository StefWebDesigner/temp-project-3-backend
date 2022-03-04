package com.revature.services;

import com.revature.models.Seller;
import com.revature.repositories.SellerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    SellerRepo sr;

    @Override
    public Seller addSeller(Seller seller) {
        return sr.save(seller);
    }

    @Override
    public Optional<Seller> getSellerById(int id) {
        return sr.findById(id);
    }

    @Override
    public List<Seller> getAllSellers() {
        return (List<Seller>) sr.findAll();
    }

    @Override
    public void updateSeller(Seller change) {
        sr.save(change);
    }

    @Override
    public boolean deleteSeller(int id) {
        try {
            sr.deleteById(id);
            return true;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Optional<Seller> getSellerByUserId(int id) {
        return sr.findByUserId(id);
    }

//    @Override
//    public Optional<Seller> getShopBySellerId(int parseInt) {
//        return sr.findBySellerId(parseInt);
//    }
//
//    @Override
//    public Optional<Seller> getInvoiceByShopId(int sellerId) {
//        return sr.findByShopId(sellerId);
//    }

//    @Override
//    public Optional<Seller> getInvoiceByShop(int parseInt) {
//        return Optional.empty();
//    }

}
