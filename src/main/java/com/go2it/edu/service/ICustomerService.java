package com.go2it.edu.service;

import java.util.List;

import com.go2it.edu.entity.Customer;

/**
 * @author Alex Ryzhkov
 */
public interface ICustomerService {
	Customer findById(int id);

	Customer findByName(String name);

	Customer save(Customer customer);

	void remove(int id);

	boolean updateCcNo(int id, String ccNo);

	public List<String> getNamesBySumPaid(double sumPayed);

}
