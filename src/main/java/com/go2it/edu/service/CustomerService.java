package com.go2it.edu.service;

import javax.transaction.Transactional;

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
	private CustomerRepository customerRepository;

	@Override
	public Customer findById(int id) {
		return customerRepository.findById(id);
	}

	@Transactional
	@Override
	public void save(Customer customer){
		customerRepository.save(customer);
	}

	@Transactional
	@Override
	public void remove(int id){
		customerRepository.remove(id);
	}

	@Transactional
	@Override
	public boolean updateCcNo(int id, String ccNo){
		Customer customerToUpdate= customerRepository.findById(id);
		if (customerToUpdate != null) {
			customerToUpdate.setCcNo(ccNo);
			return customerRepository.update(customerToUpdate);
		}
		return false;
	}
}

