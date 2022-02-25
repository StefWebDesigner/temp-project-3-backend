package com.revature.services;

import com.revature.models.Customer;
import com.revature.repositories.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepo cr;

    @Override
    public Customer addCustomer(Customer cust) {
        return cr.save(cust);
    }

    @Override
    public Customer getCustomerById(int id) {
        return cr.findById(id).orElse(new Customer());
    }

    @Override
    public List<Customer> getAllCustomers() {
        return (List<Customer>) cr.findAll();
    }

    @Override
    public void updateCustomer(Customer change) {
        cr.save(change);
    }

    @Override
    public boolean deleteCustomer(int id) {
        try {
            cr.deleteById(id);
            return true;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return false;
        }
    }

}
