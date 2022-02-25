package com.revature.controllers;

import com.revature.services.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SellerController {

    @Autowired
    SellerService sellerService;


}
