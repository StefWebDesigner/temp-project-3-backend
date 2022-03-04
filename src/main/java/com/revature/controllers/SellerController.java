package com.revature.controllers;

import com.revature.models.Seller;
import com.revature.services.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RestController
public class SellerController {

    @Autowired
    SellerService sellerService;

    /**
     * Method retrieves a Sellers data from the database/backend by an id.
     *
     * @param id The id of the Seller to be retrieved
     * @return Returns the retrieved Seller data from the database.
     */

    @GetMapping(value = "/sellers/user/{id}")
    public ResponseEntity<Seller> getSellerByUserId(@PathVariable("id") String id) {
        Optional<Seller> opSeller = sellerService.getSellerByUserId(Integer.parseInt(id));
        return opSeller.map(seller -> new ResponseEntity<>(seller, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

//    /**
//     * Method retrieves a Shop data from the database/backend by an id.
//     *
//     * @param id The id of the Seller to be retrieved
//     * @return Returns the retrieved Seller data from the database.
//     */
//    @GetMapping(value = "/shop/sellers/{id}")
//    public ResponseEntity<Seller> getShopBySellerId(@PathVariable("id") String id) {
//        Optional<Seller> opShop = sellerService.getShopBySellerId(Integer.parseInt(id));
//        return opShop.map(shop -> new ResponseEntity<>(shop, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
//    }
//
//    /**
//     * Method retrieves a invoice data from the database/backend by an id.
//     *
//     * @param id The id of the Shop to be retrieved
//     * @return Returns the retrieved invoice data from the database.
//     */
//    @GetMapping(value = "/invoices/shop/{id}")
//    public ResponseEntity<Seller> getInvoiceByShopId(@PathVariable("id") String id) {
//        Optional<Seller> opInvoice = sellerService.getInvoiceByShop(Integer.parseInt(id));
//        return opInvoice.map(invoice -> new ResponseEntity<>(invoice, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
//    }

}


