package com.revature.controllers;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.ProductReview;
import com.revature.models.User;
import com.revature.services.ProductReviewService;
import com.revature.services.ProductServiceImpl;
import com.revature.services.UserServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class ProductReviewController {
    private final ProductReviewService productReviewService;
    private final UserServiceImpl userService;
    private final ProductServiceImpl productService;

    @Autowired
    public ProductReviewController(ProductReviewService productReviewService, UserServiceImpl userService, ProductServiceImpl productService) {
        this.productReviewService = productReviewService;
        this.userService = userService;
        this.productService = productService;
    }

    @PostMapping("/create-product-review")
    public ResponseEntity<ProductReview> newProductReview(@RequestBody ProductReview productReview) {
        try {
            //TODO set userId to this user
            ProductReview createdReview = productReviewService.addProductReview(productReview);

            if (createdReview == null) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            } else {
                return new ResponseEntity<>(createdReview, HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/product-reviews")
    public ResponseEntity<List> getProductReviews() {
        try {
            List<ProductReview> reviews = productReviewService.findAllProductReviews();

            return new ResponseEntity<>(reviews, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/product-reviews/user/{id}")
    public ResponseEntity<List> getProductReviewByUser(@PathVariable("id") int id) {
        try {
            List<ProductReview> reviews = productReviewService.findAllProductReviewsByUserId(id);

            return new ResponseEntity<>(reviews, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/product-reviews/product/{id}")
    public ResponseEntity<List> getProductReviewByProduct(@PathVariable("id") int id) {
        try {
            List<ProductReview> reviews = productReviewService.findAllProductReviewsByProductId(id);

            return new ResponseEntity<>(reviews, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update-product-review")
    public ResponseEntity<ProductReview> updateProductReview(@RequestBody ProductReview productReview, Authentication auth) {
        try {
            User user = userService.getUserByUsername(auth.getName());

            boolean updated = productReviewService.updateProductReview(productReview);

            if (updated) {
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.FAILED_DEPENDENCY);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping()
    public ResponseEntity<ProductReview> deleteProductReview(@RequestBody ProductReview productReview) {
        try {
            String param = "";

            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
