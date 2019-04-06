package com.go2it.edu.repository;

import java.util.List;

import com.go2it.edu.entity.Payment;

/**
 * @author Alex Ryzhkov
 */
public interface IPaymentRepository {
	public List<Payment> findByMerchantId(int id);

	List<Payment> findByMerchantIdHibernateSpecific(int id);

	public double getPaymentsSum();

	public List<Payment> getLargePayments(double limit);

	public Payment findById(int id);

	void save(Payment payment);
}
