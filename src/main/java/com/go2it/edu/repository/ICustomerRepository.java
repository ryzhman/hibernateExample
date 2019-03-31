package com.go2it.edu.repository;

import com.go2it.edu.entity.Customer;

/**
 * @author Alex Ryzhkov
 */
public interface ICustomerRepository {
	public Customer findById(int id);

	public void save(Customer customer);

}
