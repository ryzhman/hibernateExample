package com.go2it.edu.repository;

import java.util.List;

import com.go2it.edu.entity.Merchant;
import com.go2it.edu.entity.Result;

/**
 * @author Alex Ryzhkov
 */
public interface IMerchantRepository {
	Merchant findById(int id);

	public List<Merchant> getSortedByNeedToPay();

	public List<Result> getTotalReport();

	void save(Merchant m);

	Merchant getByName(String name);
}
