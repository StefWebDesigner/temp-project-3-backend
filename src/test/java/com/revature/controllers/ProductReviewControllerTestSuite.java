package com.revature.controllers;

import static org.mockito.Mockito.mock;

import com.revature.services.ProductReviewService;
import com.revature.services.UserService;

import org.junit.jupiter.api.BeforeEach;

public class ProductReviewControllerTestSuite {
    ProductReviewController sut;
    ProductReviewService mockProductReviewService;
    UserService mockUserService;
    

    @BeforeEach
    void setUp() throws Exception {
        mockUserService = mock(UserService.class);
        mockProductReviewService = mock(ProductReviewService.class);
        sut = new ProductReviewController(mockProductReviewService, mockUserService);
    }

}
