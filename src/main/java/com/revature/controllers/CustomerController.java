package com.revature.controllers;

import com.revature.models.Customer;
import com.revature.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping(value = "/register/customer")
    public ResponseEntity<Customer> newCustomer(@RequestBody Customer cust)
    {
        Customer created = customerService.addCustomer(cust);

        if (created.getId()!=0) {
            return new ResponseEntity<>(created, HttpStatus.OK);
        }
        else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
