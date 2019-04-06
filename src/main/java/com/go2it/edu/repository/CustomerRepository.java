package com.go2it.edu.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.go2it.edu.entity.Customer;

/**
 * @author Alex Ryzhkov
 */
@Repository
public class CustomerRepository implements ICustomerRepository {
	private final Logger logger = LoggerFactory.getLogger(CustomerRepository.class);
	@PersistenceContext private EntityManager em;

	@Override
	public Customer findById(int id) {
		Customer customer = em.find(Customer.class, id);
		return customer;
	}

	@Override
	public void save(Customer customer) {
		if (customer.getId() == 0) {
			em.persist(customer);
		} else {
			em.merge(customer);
		}
	}

	@Override
	public void remove(int id) {
		Customer customer = findById(id);
		if (customer != null) {
			em.remove(customer);
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
	public List<String> getNamesBySumPaid(double sumPaid){
		String txt = "SELECT DISTINCT c.name FROM ";
		txt += "payment p, customer c " ;
		txt += "WHERE c.id = p.customerId AND p.sumPaid >" 	+ sumPaid;
		TypedQuery<String> query = em.createQuery(txt, String.class);
		return query.getResultList();
	}

	@Override
	public Customer findByName(String name) {
		try {
			Query query = em.createQuery("from customer where name=:name");
			query.setParameter("name", name);
			Customer customer = (Customer) query.getSingleResult();
			return customer;
		} catch (NoResultException e) {
			logger.warn("No customer was found by the name: " + name);
			return null;
		}
	}
}



