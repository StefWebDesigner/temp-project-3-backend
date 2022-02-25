package com.revature.repositories;

import com.revature.models.Customer;
import com.revature.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends CrudRepository<Customer, Integer> {

}
