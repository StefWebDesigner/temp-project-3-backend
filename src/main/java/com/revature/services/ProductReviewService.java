package com.revature.services;

import java.util.List;

import com.revature.models.ProductReview;
import com.revature.repositories.ProductReviewRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductReviewService {
    private final ProductReviewRepo productReviewRepo;

    /**
     * Constructor
     * @param ProductReviewRepo
     */
    @Autowired
    public ProductReviewService(ProductReviewRepo productReviewRepo) {
        this.productReviewRepo = productReviewRepo;
    }

    /**
     * @param 
     * @return Returns a ProductReview object after it has been added to the database
     * @throws Exception
     */
    public ProductReview addProductReview(ProductReview newProductReview) throws Exception {
        // TODO
        if (newProductReview == null){
            throw new Exception("Invalid product review data.");
        }
        return null;
    }

    /**
     * @return Returns a List<ProductReview> of all existing ProductReviews
     */
    public List<ProductReview> findAllProductReviews() {
        // TODO
        return null;
    }

    /**
     * @param
     * @return Returns a List<ProductReview> by User Id
     */
    public List<ProductReview> findAllProductReviewsByUserId(int userId) {
        // TODO
        return null;
    }

    /**
     * @param 
     * @return Returns a List<ProductReview> by Product Id
     */
    public List<ProductReview> findAllProductReviewsByProductId(int productId) {
        // TODO
        return null;
    }

    /**
     * @param 
     * @return Returns true if ProductReview updated, false if update unsuccesful
     */
    public boolean updateProductReview(ProductReview productReview) {
        // TODO
        return false;
    }

     /**
     * @param 
     * @return Returns true if ProductReview deleted, false if delete unsuccesful
     */
    public boolean deleteProductReview(ProductReview productReview) {
        // TODO
        return false;
    }

    /**
     * IsValidProductReview
     */
}
