package com.coreteka.service;

import com.coreteka.dao.CustomerDao;
import com.coreteka.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;

    @Transactional
    @Override
    public List<Customer> getCustomers(String sortParam) {
        return customerDao.listCustomers(sortParam);
    }

    @Transactional
    @Override
    public void save(Customer customer){
        customerDao.saveCustomer(customer);
    }

    @Transactional
    @Override
    public Customer getCustomer(int id) {
        return customerDao.getCustomer(id);
    }

    @Transactional
    @Override
    public void deleteCustomer(int id) {
        customerDao.deleteCustomer(id);
    }

    @Transactional
    @Override
    public List<Customer> searchCustomers(String theSearchName) {
        return customerDao.searchCustomers(theSearchName);
    }


}
