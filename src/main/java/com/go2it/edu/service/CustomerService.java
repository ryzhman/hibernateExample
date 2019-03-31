package com.go2it.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.go2it.edu.entity.Customer;
import com.go2it.edu.repository.CustomerRepository;

/**
 * @author Alex Ryzhkov
 */
@Service
public class CustomerService implements ICustomerService{
	@Autowired
	private CustomerRepository customerDao;
	public Customer findById(int id) {
		return customerDao.findById(id);
	}
}

