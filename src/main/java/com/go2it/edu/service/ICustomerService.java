package com.go2it.edu.service;

import com.go2it.edu.entity.Customer;

/**
 * @author Alex Ryzhkov
 */
public interface ICustomerService {
	Customer findById(int id);

	void save(Customer customer);

	void remove(int id);

	boolean updateCcNo(int id, String ccNo);
}
