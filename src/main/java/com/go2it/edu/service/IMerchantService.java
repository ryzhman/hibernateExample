package com.go2it.edu.service;

import java.util.List;

import com.go2it.edu.entity.Merchant;
import com.go2it.edu.entity.Result;

/**
 * @author Alex Ryzhkov
 */
public interface IMerchantService {
	Merchant findById(int id);

	public List<Merchant> getSortedByNeedToPay();

	public List<Result> getTotalReport();

	Merchant getByName(String name);

	void save(Merchant merchant);
}
