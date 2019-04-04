package com.go2it.edu.repository;

import java.util.List;

import com.go2it.edu.entity.Merchant;

/**
 * @author Alex Ryzhkov
 */
public interface IMerchantRepository {
	Merchant findById(int id);
	public List<Merchant> getSortedByNeedToPay();

}
