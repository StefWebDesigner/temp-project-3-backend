package com.revature.repositories;

import com.revature.models.ProductReview;

import org.springframework.data.repository.CrudRepository;

public interface ProductReviewRepo extends CrudRepository<ProductReview, Integer> {

}
