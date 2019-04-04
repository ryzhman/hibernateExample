package com.go2it.edu.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

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

}



