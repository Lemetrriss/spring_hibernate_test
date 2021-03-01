package com.coreteka.dao;

import com.coreteka.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class CustomerDaoImpl implements CustomerDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> listCustomers(String sortParam) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Customer order by " + sortParam, Customer.class).getResultList();
//        return session.createNativeQuery("select * from customer", Customer.class).getResultList();
    }

    @Override
    public void saveCustomer(Customer customer) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(customer);
    }

    @Override
    public Customer getCustomer(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Customer.class, id);
    }

    @Override
    public void deleteCustomer(int id) {
        Session session = sessionFactory.getCurrentSession();
//        Customer customer = session.get(Customer.class, id);
//        session.delete(customer);
        session.createQuery("delete from Customer where id=:customerId")
                .setParameter("customerId", id)
                .executeUpdate();
    }

    @Override
    public List<Customer> searchCustomers(String theSearchName) {
        Session session = sessionFactory.getCurrentSession();
        Query<Customer> query;
        if (theSearchName != null && theSearchName.trim().length() > 0) {
            query = session.createQuery("from Customer where lower(firstName) like :searchName or lower(lastName) like :searchName", Customer.class)
                    .setParameter("searchName", "%" + theSearchName.toLowerCase() + "%");
        } else {
            query = session.createQuery("from Customer order by lastName", Customer.class);
        }
        return query.getResultList();
    }

}
