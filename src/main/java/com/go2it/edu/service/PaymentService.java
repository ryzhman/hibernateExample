package com.go2it.edu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.go2it.edu.entity.Payment;
import com.go2it.edu.repository.IPaymentRepository;

/**
 * @author Alex Ryzhkov
 */
@Service
public class PaymentService implements IPaymentService {
	@Autowired private IPaymentRepository paymentRepository;

	@Override
	public List<Payment> findByMerchantId(int id) {
		//Hibernate specific implementation
		return paymentRepository.findByMerchantIdHibernateSpecific(id);
		//		return paymentRepository.findByMerchantId(id);
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
}
