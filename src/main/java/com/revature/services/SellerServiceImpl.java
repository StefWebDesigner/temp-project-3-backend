package com.revature.services;

import com.revature.models.Customer;
import com.revature.models.Seller;
import com.revature.repositories.SellerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    SellerRepo sr;

    @Override
    public Seller addSeller(Seller seller) {
        return sr.save(seller);
    }

    @Override
    public Seller getSellerById(int id) {
        return sr.findById(id).orElse(new Seller());
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

}
