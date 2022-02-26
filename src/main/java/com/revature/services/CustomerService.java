package com.revature.services;

import com.revature.models.Customer;

import java.util.List;

public interface CustomerService {

    public Customer addCustomer(Customer cust);
    public Customer getCustomerById(int id);
    public List<Customer> getAllCustomers();
    public void updateCustomer(Customer change);
    public boolean deleteCustomer(int id);

}
