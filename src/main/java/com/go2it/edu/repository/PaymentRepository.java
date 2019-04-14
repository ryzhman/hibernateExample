package com.go2it.edu.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Service;

import com.go2it.edu.entity.Payment;

/**
 * @author Alex Ryzhkov
 */
@Service
public class PaymentRepository implements IPaymentRepository {
	private static Logger log = LoggerFactory.getLogger(PaymentRepository.class);

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<Payment> findByMerchantId(int id) {
		TypedQuery<Payment> query = sessionFactory.getCurrentSession().createQuery("SELECT p FROM  payment p WHERE p.merchantId = " + id,
				Payment.class);
		return query.getResultList();
	}

	@Override
	public double getPaymentsSum() {
		TypedQuery<Double> query = sessionFactory.getCurrentSession().createQuery("SELECT SUM(p.sumPaid) FROM payment p", Double.class);
		return query.getSingleResult();
	}

	@Override
	public List<Payment> getLargePayments(double limit) {
		TypedQuery<Payment> query = sessionFactory.getCurrentSession().createQuery("SELECT p FROM payment p WHERE p.sumPaid > :limit",
				Payment.class);
		query.setParameter("limit", limit);
		return query.getResultList();
	}

	@Override
	public Payment findById(int id) {
		return sessionFactory.getCurrentSession().find(Payment.class, id);
	}

	@Override
	public void save(Payment payment) {
		if (payment.getId() == 0) {
			sessionFactory.getCurrentSession().persist(payment);
		} else {
			sessionFactory.getCurrentSession().merge(payment);
		}
	}
}
