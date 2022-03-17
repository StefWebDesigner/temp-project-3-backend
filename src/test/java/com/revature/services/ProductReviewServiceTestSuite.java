package com.revature.services;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.revature.models.ProductReview;
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

    @Test
    void test_addProductReview_returnsProductReview_givenValidProductReview() {
        ProductReview newProductReview = new ProductReview();
        when(mockProductReviewRepo.save(newProductReview)).thenReturn(newProductReview);
        
        ProductReview result = sut.addProductReview(newProductReview);
        
        Assertions.assertEquals(result,newProductReview);
        verify(mockProductReviewRepo, times(1)).save(newProductReview);
    }

    // @Test
    // void test_addProductReview_throwsException_givenUnauthorizedUser() {
    //     ProductReview newProductReview = new ProductReview();
    //     when(mockProductReviewRepo.save(newProductReview)).thenReturn(newProductReview);
        
    //     ProductReview result = sut.addProductReview(newProductReview);
        
    //     Assertions.assertEquals(result,newProductReview);
    //     verify(mockProductReviewRepo, times(1)).save(newProductReview);
    // }

    @Test
    void test_addProductReview_throwsRuntimeException_givenNullProductReview() {
        ProductReview productReview = null;
        RuntimeException thrown = Assertions.assertThrows(RuntimeException.class, () -> {
			sut.addProductReview(productReview);
		});
        Assertions.assertEquals("Invalid product review.", thrown.getMessage());
        verify(mockProductReviewRepo, times(0)).save(productReview);
    }

    @Test
    void test_addProductReview_throwsRuntimeException_givenInvalidProductReviewTitle() {
        ProductReview productReview = null; //TODO give invalid title
        Exception thrown = Assertions.assertThrows(Exception.class, () -> {
			sut.addProductReview(productReview);
		});
        Assertions.assertEquals("expected", thrown.getMessage());
        verify(mockProductReviewRepo, times(0)).save(productReview);
    }

    @Test
    void test_addProductReview_throwsRuntimeException_givenInvalidProductReviewComment() {
        ProductReview productReview = null; //TODO give invalid comment
        Exception thrown = Assertions.assertThrows(Exception.class, () -> {
			sut.addProductReview(productReview);
		});
        Assertions.assertEquals("expected", thrown.getMessage());
        verify(mockProductReviewRepo, times(0)).save(productReview);
    }

    @Test
    void test_addProductReview_throwsRuntimeException_givenInvalidProductReviewRating() {
        ProductReview productReview = null; //TODO give invalid rating
        Exception thrown = Assertions.assertThrows(Exception.class, () -> {
			sut.addProductReview(productReview);
		});
        Assertions.assertEquals("expected", thrown.getMessage());
        verify(mockProductReviewRepo, times(0)).save(productReview);
    }

    @Test
    void test_findAllProductReviews_returnsProductReviews() {
        List<ProductReview> allProductReviews = new ArrayList<>();

        when(mockProductReviewRepo.findAll()).thenReturn(allProductReviews);
        
        List<ProductReview> result = sut.findAllProductReviews();
        
        Assertions.assertEquals(result,allProductReviews);
        verify(mockProductReviewRepo, times(1)).findAll();
    }
}