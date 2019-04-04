package com.go2it.edu.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.go2it.edu.entity.Merchant;
import com.go2it.edu.entity.Result;

/**
 * @author Alex Ryzhkov
 */
@Repository
public class MerchantRepository implements IMerchantRepository {
	@PersistenceContext private EntityManager em;

	@Override
	public Merchant findById(int id) {
		Merchant m = em.find(Merchant.class, id);
		return m;
	}

	@Override
	public List<Merchant> getSortedByNeedToPay() {
		String txt = "SELECT m FROM merchant m ORDER BY m.needToSend";
		TypedQuery<Merchant> query = em.createQuery(txt, Merchant.class);
		return query.getResultList();
	}

	@Override
	public List<Result> getTotalReport() {
		String txt = "SELECT new com.go2it.edu.entity.Result (p.merchant.name, count(p), SUM(p.chargePaid))";
		txt += "FROM payment p GROUP BY p.merchant.name";
		TypedQuery<Result> query = em.createQuery(txt, Result.class);
		return query.getResultList();
	}
}
