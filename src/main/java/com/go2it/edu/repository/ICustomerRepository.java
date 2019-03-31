package com.go2it.edu.repository;

import com.go2it.edu.entity.Customer;

/**
 * @author Alex Ryzhkov
 */
public interface ICustomerRepository {
	Customer findById(int id);

	void save(Customer customer);

	void remove(int id);

	boolean update(Customer updatedCustomer);
}
