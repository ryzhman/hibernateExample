package com.go2it.edu.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.go2it.edu.entity.Merchant;

/**
 * @author Alex Ryzhkov
 */
@Repository
public class MerchantRepository implements IMerchantRepository {
	@PersistenceContext
	private EntityManager em;

	@Override
	public Merchant findById(int id) {
		Merchant m = em.find(Merchant.class, id);
		return m;
	}
}
