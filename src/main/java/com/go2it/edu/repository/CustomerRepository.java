package com.go2it.edu.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.go2it.edu.entity.Customer;

/**
 * @author Alex Ryzhkov
 */
@Repository
public class CustomerRepository implements ICustomerRepository {
	@PersistenceContext private EntityManager em;

	@Override
	public Customer findById(int id) {
		Customer customer = null;
		customer = em.find(Customer.class, id);
		return customer;
	}

	@Override
	public void save(Customer customer) {
		em.persist(customer);
	}

	@Override
	public void remove(int id) {
		Customer customer = findById(id);
		if (customer != null) {
			em.remove(customer);
		}
	}
}



