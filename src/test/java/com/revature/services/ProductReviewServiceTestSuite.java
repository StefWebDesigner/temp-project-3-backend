package com.revature.services;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.revature.repositories.ProductReviewRepo;
import com.revature.repositories.UserRepo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductReviewServiceTestSuite {
    ProductReviewService sut;
    ProductReviewRepo mockProductReviewRepo;
    UserRepo mockUserRepo;
    UserService mockUserService;

    @BeforeEach
    void setUp() throws Exception {
        mockProductReviewRepo = mock(ProductReviewRepo.class);
        mockUserRepo = mock(UserRepo.class);
        mockUserService = mock(UserService.class);
        sut = new ProductReviewService(mockProductReviewRepo, mockUserService);
    }
}