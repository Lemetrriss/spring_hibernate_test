package com.coreteka.dao;

import com.coreteka.entity.Customer;

import java.util.List;

public interface CustomerDao {
    List<Customer> listCustomers(String sortParam);
    void saveCustomer(Customer customer);
    Customer getCustomer(int id);
    void deleteCustomer(int id);
    public List<Customer> searchCustomers(String theSearchName);
}
