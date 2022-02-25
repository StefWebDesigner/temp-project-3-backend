package com.revature.services;

import com.revature.models.Seller;

import java.util.List;

public interface SellerService {

    public Seller addSeller(Seller seller);
    public Seller getSellerById(int id);
    public List<Seller> getAllSellers();
    public void updateSeller(Seller change);
    public boolean deleteSeller(int id);

}
