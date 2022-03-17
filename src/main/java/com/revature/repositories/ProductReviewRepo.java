package com.revature.repositories;

import com.revature.models.ProductReview;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductReviewRepo extends CrudRepository<ProductReview, Integer> {
    
    @Query("SELECT * FROM ProductReview p WHERE p.user_id = :userId")
    Iterable<ProductReview> findAllByUserId(int userId);
    
    @Query("SELECT * FROM ProductReview p WHERE p.product_id = :productId")
    Iterable<ProductReview> findAllByProductId(int productId);

}
