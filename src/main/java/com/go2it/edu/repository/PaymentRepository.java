package com.go2it.edu.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.go2it.edu.entity.Payment;

/**
 * @author Alex Ryzhkov
 */
@Service
public class PaymentRepository implements IPaymentRepository {
	private static Logger log = LoggerFactory.getLogger(PaymentRepository.class);

	@PersistenceContext private EntityManager em;

	@Override
	public List<Payment> findByMerchantId(int id) {
		TypedQuery<Payment> query = em.createQuery("SELECT p FROM  payment p WHERE p.merchantId = " + id,
				Payment.class);
		return query.getResultList();

	}

	/**
	 * Hibernate required an explicit transaction even for READ operations (JPA does not).
	 * See the specific HQL syntax
	 *
	 * @param id
	 * @return
	 */
	@Transactional
	@Override
	public List<Payment> findByMerchantIdHibernateSpecific(int id) {
		Session currentSession = em.unwrap(Session.class);
		List<Payment> result = null;
		try {
			result = currentSession.createQuery("FROM  payment p WHERE p.merchantId = " + id, Payment.class)
					.list();
			return result;
		} catch (Exception e) {
			log.error("Exception during fetching a payment by merchantId: " + id + ". Exceptiom - " + e);
		}
		return result;
	}

	@Override
	public double getPaymentsSum() {
		TypedQuery<Double> query = em.createQuery ("SELECT SUM(p.sumPaid) FROM payment p", Double.class);
		return query.getSingleResult();
	}
}
