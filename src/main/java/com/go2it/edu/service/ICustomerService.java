package com.go2it.edu.service;

import com.go2it.edu.entity.Customer;

/**
 * @author Alex Ryzhkov
 */
public interface ICustomerService {
	public Customer findById(int id);

	public void save(Customer customer);

	public void remove(int id);
}
