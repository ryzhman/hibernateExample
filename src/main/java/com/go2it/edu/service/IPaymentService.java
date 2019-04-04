package com.go2it.edu.service;

import java.util.List;

import com.go2it.edu.entity.Payment;

/**
 * @author Alex Ryzhkov
 */
public interface IPaymentService {
	public List<Payment> findByMerchantId(int id);

	public double getPaymentsSum();

	public List<Payment> getLargePayments(double limit);

	public Payment findById(int id);
}
