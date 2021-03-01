package com.coreteka.service;

import com.coreteka.entity.Customer;
import java.util.List;

public interface CustomerService {
    List<Customer> getCustomers(String sortParam);
    void save(Customer customer);
    Customer getCustomer(int id);
    void deleteCustomer(int id);
    List<Customer> searchCustomers(String theSearchName);
}
