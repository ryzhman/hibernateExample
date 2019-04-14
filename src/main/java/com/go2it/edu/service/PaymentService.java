package com.go2it.edu.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.go2it.edu.entity.Customer;
import com.go2it.edu.entity.Merchant;
import com.go2it.edu.entity.Payment;
import com.go2it.edu.repository.IPaymentRepository;

/**
 * @author Alex Ryzhkov
 */
@Service
public class PaymentService implements IPaymentService {
	@Autowired private IPaymentRepository paymentRepository;
	@Autowired private ICustomerService customerService;
	@Autowired private IMerchantService merchantService;

	@Override
	public List<Payment> findByMerchantId(int id) {
				return paymentRepository.findByMerchantId(id);
	}

	@Override
	public double getPaymentsSum() {
		return paymentRepository.getPaymentsSum();
	}

	@Override
	public List<Payment> getLargePayments(double limit) {
		return paymentRepository.getLargePayments(limit);
	}

	@Override
	public Payment findById(int id) {
		return paymentRepository.findById(id);
	}

	@Override
	public void save(Payment payment) {
		paymentRepository.save(payment);
	}

	@Override
	@Transactional
	public void addNewPayment(Payment payment) {
		//save Customer and Merchant first to get their IDs in persistence context
		//otherwise, Payment will not be saved
		Customer customer = payment.getCustomer();
		Customer existingCustomer = customerService.findByName(customer.getName());
		if (existingCustomer == null) {
			customerService.save(customer);
		} else {
			//to preserve the ID
			payment.setCustomer(existingCustomer);
		}

		Merchant merchant = payment.getMerchant();
		Merchant existingMerchant = merchantService.getByName(merchant.getName());
		if (existingMerchant == null) {
			merchantService.save(payment.getMerchant());
		} else {
			payment.setMerchant(existingMerchant);
		}
		save(payment);
	}
}
