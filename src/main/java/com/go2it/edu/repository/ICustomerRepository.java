package com.go2it.edu.repository;

import java.util.List;

import com.go2it.edu.entity.Customer;

/**
 * @author Alex Ryzhkov
 */
public interface ICustomerRepository {
	Customer findById(int id);

	Customer findByName(String name);

	void save(Customer customer);

	void remove(int id);

	boolean update(Customer updatedCustomer);

	public List<String> getNamesBySumPaid(double sumPayed);

}
