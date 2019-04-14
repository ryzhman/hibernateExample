package com.go2it.edu.repository;

import com.go2it.edu.entity.Customer;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;


@Repository
public class CustomerRepository implements ICustomerRepository {
    //	@Autowired
//	private EntityManagerFactoryAccessor entityManagerFactoryAccessor;
    private final Logger logger = LoggerFactory.getLogger(CustomerRepository.class);
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Customer findById(int id) {
        Customer customer = sessionFactory.getCurrentSession().find(Customer.class, id);
        return customer;
    }

    @Override
    public void save(Customer customer) {
        if (customer.getId() == 0) {
            sessionFactory.getCurrentSession().persist(customer);
        } else {
            sessionFactory.getCurrentSession().merge(customer);
        }
    }

    @Override
    public void remove(int id) {
        Customer customer = findById(id);
        if (customer != null) {
            sessionFactory.getCurrentSession().remove(customer);
        }
    }

    @Override
    public boolean update(Customer updatedCustomer) {
        if (updatedCustomer != null) {
            return true;
        } else {
            return true;
        }
    }

    @Override
    public List<String> getNamesBySumPaid(double sumPaid) {
        String txt = "SELECT DISTINCT c.name FROM ";
        txt += "payment p, customer c ";
        txt += "WHERE c.id = p.customerId AND p.sumPaid >" + sumPaid;
        TypedQuery<String> query = sessionFactory.getCurrentSession().createQuery(txt, String.class);
        return query.getResultList();
    }

    @Override
    public Customer findByName(String name) {
        try {
            Query query = sessionFactory.getCurrentSession().createQuery("from customer where name=:name");
            query.setParameter("name", name);
            Customer customer = (Customer) query.getSingleResult();
            return customer;
        } catch (NoResultException e) {
            logger.warn("No customer was found by the name: " + name);
            return null;
        }
    }
}



