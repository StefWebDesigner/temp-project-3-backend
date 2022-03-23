package com.revature.controllers;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.revature.models.Product;
import com.revature.models.ProductReview;
import com.revature.models.User;
import com.revature.services.ProductReviewService;
import com.revature.services.ProductServiceImpl;
import com.revature.services.UserServiceImpl;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class ProductReviewControllerTestSuite {
    ProductReviewController sut;
    ProductReviewService mockProductReviewService;
    UserServiceImpl mockUserService;
    ProductServiceImpl mockProductService;
    User user;
    Product product;

    @BeforeEach
    void setUp() throws Exception {
        mockUserService = mock(UserServiceImpl.class);
        mockProductReviewService = mock(ProductReviewService.class);
        mockProductService = mock(ProductServiceImpl.class);
        sut = new ProductReviewController(mockProductReviewService, mockUserService, mockProductService);
        
    }

    @Test
    public void test_newProductReview_returns200_givenValidRequest() {
        user = new User();
        product = new Product();
        // user.setId(1);
        // product.setId(1);
        ProductReview pr = new ProductReview(1, "valid", "valid", 3, user, product);
        // MockHttpServletRequest request = new MockHttpServletRequest();
        // RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        
        when(mockProductReviewService.addProductReview(pr)).thenReturn(pr);

        ResponseEntity<ProductReview> responseEntity = sut.newProductReview(pr);

        Assertions.assertEquals(200, responseEntity.getStatusCode());
    }

    @Test
    public void test_newProductReview_returns400_givenInvalidRequest() {

    }

    @Test
    public void test_newProductReview_returns500_onServerError() {

    }

}
