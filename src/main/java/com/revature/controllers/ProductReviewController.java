package com.revature.controllers;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.ProductReview;
import com.revature.services.ProductReviewService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class ProductReviewController {
    private final ProductReviewService productReviewService;

    @Autowired
    public ProductReviewController(ProductReviewService productReviewService){
        this.productReviewService = productReviewService;
    }

    @PostMapping("/create-product-review")
    public ResponseEntity<ProductReview> newProductReview(@RequestBody ProductReview productReview){
        try{
            ProductReview createdReview = productReviewService.addProductReview(productReview);

            if (createdReview == null){
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            } else {
                return new ResponseEntity<>(createdReview, HttpStatus.OK);
            }
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping()
    public ResponseEntity<ProductReview> getProductReview(@RequestBody ProductReview productReview) {
        try{
            String param = "";
            List<ProductReview> reviews = new ArrayList<>();
            switch (param){
                case "/user-id":
                    break;
                case "/product-id":
                    break;
                default:
                    //all
                    reviews = productReviewService.findAllProductReviews();
                    break;
            }
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping()
    public ResponseEntity<ProductReview> updateProductReview(@RequestBody ProductReview productReview) {
        try{
            String param = "";

            
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping()
    public ResponseEntity<ProductReview> deleteProductReview(@RequestBody ProductReview productReview) {
        try{
            String param = "";


            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
