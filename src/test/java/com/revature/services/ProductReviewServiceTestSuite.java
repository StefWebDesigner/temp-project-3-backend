package com.revature.services;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.ProductReview;
import com.revature.repositories.ProductReviewRepo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductReviewServiceTestSuite {
    ProductReviewService sut;
    ProductReviewRepo mockProductReviewRepo;
    AuthService mockAuthService;

    @BeforeEach
    void setUp() throws Exception {
        mockProductReviewRepo = mock(ProductReviewRepo.class);
        mockAuthService = mock(AuthService.class);
        sut = new ProductReviewService(mockProductReviewRepo, mockAuthService);
    }

    @Test
    void test_addProductReview_returnsProductReview_givenValidProductReview() {
        ProductReview newProductReview = new ProductReview();
        when(mockProductReviewRepo.save(newProductReview)).thenReturn(newProductReview);

        ProductReview result = sut.addProductReview(newProductReview);

        Assertions.assertEquals(result, newProductReview);
        verify(mockProductReviewRepo, times(1)).save(newProductReview);
    }

    // @Test
    // void test_addProductReview_throwsException_givenUnauthorizedUser() {
    // ProductReview newProductReview = new ProductReview();
    // when(mockProductReviewRepo.save(newProductReview)).thenReturn(newProductReview);

    // ProductReview result = sut.addProductReview(newProductReview);

    // Assertions.assertEquals(result,newProductReview);
    // verify(mockProductReviewRepo, times(1)).save(newProductReview);
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
        ProductReview productReview = null; // TODO give invalid title
        RuntimeException thrown = Assertions.assertThrows(RuntimeException.class, () -> {
            sut.addProductReview(productReview);
        });
        Assertions.assertEquals("expected", thrown.getMessage());
        verify(mockProductReviewRepo, times(0)).save(productReview);
    }

    @Test
    void test_addProductReview_throwsRuntimeException_givenInvalidProductReviewComment() {
        ProductReview productReview = null; // TODO give invalid comment
        RuntimeException thrown = Assertions.assertThrows(RuntimeException.class, () -> {
            sut.addProductReview(productReview);
        });
        Assertions.assertEquals("expected", thrown.getMessage());
        verify(mockProductReviewRepo, times(0)).save(productReview);
    }

    @Test
    void test_addProductReview_throwsRuntimeException_givenInvalidProductReviewRating() {
        ProductReview productReview = null; // TODO give invalid rating
        RuntimeException thrown = Assertions.assertThrows(RuntimeException.class, () -> {
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

        Assertions.assertEquals(result, allProductReviews);
        verify(mockProductReviewRepo, times(1)).findAll();
    }

    // TODO findAll() test for no reviews returns null?

    @Test
    void test_findAllProductReviewsByUserId_returnsProductReviews_givenValidUserId() {
        List<ProductReview> allProductReviewsByUserId = new ArrayList<>();
        // ProductReview productReview1 = new ProductReview()
        // ProductReview productReview2 = new ProductReview()
        int validUserId = 1;
        when(mockProductReviewRepo.findAllByUserId(validUserId)).thenReturn(allProductReviewsByUserId);

        List<ProductReview> result = sut.findAllProductReviews();

        Assertions.assertEquals(result, allProductReviewsByUserId);
        verify(mockProductReviewRepo, times(1)).findAllByUserId(validUserId);
    }

    @Test
    void test_findAllProductReviewsByUserId_returnsNull_givenValidUserId_givenUserHasNoReviews() {
        int validUserId = 1;
        when(mockProductReviewRepo.findAllByUserId(validUserId)).thenReturn(null);

        List<ProductReview> result = sut.findAllProductReviewsByUserId(validUserId);

        Assertions.assertNull(result);
        verify(mockProductReviewRepo, times(1)).findAllByUserId(validUserId);
    }

    @Test
    void test_findAllProductReviewsByUserId_throwsRuntimeException_givenInvalidUserId() {
        int invalidUserId = 0;
        RuntimeException thrown = Assertions.assertThrows(RuntimeException.class, () -> {
            sut.findAllProductReviewsByUserId(invalidUserId);
        });
        Assertions.assertEquals("message", thrown.getMessage());

        verify(mockProductReviewRepo, times(0)).findAllByUserId(invalidUserId);
    }

    @Test
    void test_findAllProductReviewsByProductId_returnsProductReviews_givenValidProductId() {
        List<ProductReview> allProductReviews = new ArrayList<>();
        // ProductReview productReview1 = new ProductReview()
        // ProductReview productReview2 = new ProductReview()
        int validProductId = 1;
        when(mockProductReviewRepo.findAllByProductId(validProductId)).thenReturn(allProductReviews);

        List<ProductReview> result = sut.findAllProductReviewsByProductId(validProductId);

        Assertions.assertEquals(result, allProductReviews);
        verify(mockProductReviewRepo, times(1)).findAllByProductId(validProductId);
    }

    @Test
    void test_findAllProductReviewsByProductId_returnsNull_givenValidProductId_givenProductHasNoReviews() {
        int validProductId = 1;
        when(mockProductReviewRepo.findAllByProductId(validProductId)).thenReturn(null);

        List<ProductReview> result = sut.findAllProductReviewsByProductId(validProductId);

        Assertions.assertNull(result);
        verify(mockProductReviewRepo, times(1)).findAllByProductId(validProductId);
    }

    @Test
    void test_findAllProductReviewsByProductId_throwsRuntimeException_givenInvalidProductId() {
        int invalidProductId = 0;
        RuntimeException thrown = Assertions.assertThrows(RuntimeException.class, () -> {
            sut.findAllProductReviewsByProductId(invalidProductId);
        });
        Assertions.assertEquals("message", thrown.getMessage());

        verify(mockProductReviewRepo, times(0)).findAllByProductId(invalidProductId);
    }
}