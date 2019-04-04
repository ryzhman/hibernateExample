package com.go2it.edu.service;

import java.util.List;

import com.go2it.edu.entity.Merchant;

/**
 * @author Alex Ryzhkov
 */
public interface IMerchantService {
	Merchant findById(int id);

	public List<Merchant> getSortedByNeedToPay();

}
