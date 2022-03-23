package com.revature.controllers;

import static org.mockito.Mockito.mock;

import com.revature.services.ProductReviewService;
import com.revature.services.ProductServiceImpl;
import com.revature.services.UserServiceImpl;

import org.junit.jupiter.api.BeforeEach;

public class ProductReviewControllerTestSuite {
    ProductReviewController sut;
    ProductReviewService mockProductReviewService;
    UserServiceImpl mockUserService;
    ProductServiceImpl mockProductService;
    

    @BeforeEach
    void setUp() throws Exception {
        mockUserService = mock(UserServiceImpl.class);
        mockProductReviewService = mock(ProductReviewService.class);
        mockProductService = mock(ProductServiceImpl.class);
        sut = new ProductReviewController(mockProductReviewService, mockUserService, mockProductService);
    }

}
