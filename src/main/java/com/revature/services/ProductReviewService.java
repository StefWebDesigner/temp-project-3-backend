package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.ProductReview;
import com.revature.repositories.ProductReviewRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.core.Authentication;

@Service
@Transactional
public class ProductReviewService {
    private final ProductReviewRepo productReviewRepo;
    private final UserService userService;

    // private final AuthService authService;
    /**
     * Constructor
     * 
     * @param userService
     * @param productReviewRepo
     */
    @Autowired
    public ProductReviewService(ProductReviewRepo productReviewRepo, UserService userService) {
        this.productReviewRepo = productReviewRepo;
        this.userService = userService;
        // this.authService = authService;
    }

    /**
     * @param
     * @return Returns a ProductReview object after it has been added to the
     *         database
     * @throws RuntimeException when provided with invalid data
     */
    public ProductReview addProductReview(ProductReview newProductReview) {
        //TODO Check for user authentication
        // int id = userService.getUserByUsername( auth.getName() ).getId();
        if (!isValidProductReview(newProductReview)) {
            throw new RuntimeException("Invalid product review.");
        }
        //check for same user, reviews same product, throw exception
        ProductReview savedProductReview = productReviewRepo.save(newProductReview);

        return savedProductReview;
    }

    /**
     * @return Returns a List<ProductReview> of all existing ProductReviews
     */
    public List<ProductReview> findAllProductReviews() {
        // TODO
        List<ProductReview> allProductReviews = new ArrayList<>();
        Iterable<ProductReview> prIterable = productReviewRepo.findAll();
        for (ProductReview pr : prIterable) {
            allProductReviews.add(pr);
        }
        return allProductReviews;
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
     * Add review reqs:
     *  valid user
     *  required fields valid:
     *      comment
     *      title
     *      rating
     */

    /**
     * @param
     * @return Returns true if ProductReview is valid--contains all required fields and the fields are within a valid range of values
     */
    public boolean isValidProductReview(ProductReview productReview) {
        // TODO
        if (productReview == null) {
            return false;
        }
        // } else if (productReview.getTitle() == null || productReview.getTitle().equals("")) {
        //     return false;
        // } else if (productReview.getComment() == null || productReview.getComment().equals("")) {
        //     return false;
        // } else if (productReview.getRating() == null || productReview.getComment().equals("")) {
        //     return false;
        // } else {
        //     return true;
        // }

        return true;
    }
}
