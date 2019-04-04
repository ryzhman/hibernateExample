package com.go2it.edu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.go2it.edu.entity.Merchant;
import com.go2it.edu.repository.MerchantRepository;

/**
 * @author Alex Ryzhkov
 */
@Service
public class MerchantService implements IMerchantService {
	@Autowired
	private MerchantRepository merchantRepository;

	@Override
	public Merchant findById(int id) {
		return merchantRepository.findById(id);
	}

	@Override
	public List<Merchant> getSortedByNeedToPay() {
		return merchantRepository.getSortedByNeedToPay();
	}
}
