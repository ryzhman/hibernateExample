package com.go2it.edu.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Alex Ryzhkov
 */
@Entity(name = "payment")
public class Payment {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) private int id;
	@Column(name = "dt") private java.sql.Date paymentDate;
	private String goods;
	@Column(name = "sumPayed") private Double sumPaid;
	@Column(name = "chargePaid") private Double chargePaid;
	private Integer merchantId;
	private Integer customerId;

	Payment() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public String getGoods() {
		return goods;
	}

	public void setGoods(String goods) {
		this.goods = goods;
	}

	public Double getSumPaid() {
		return sumPaid;
	}

	public void setSumPaid(Double sumPaid) {
		this.sumPaid = sumPaid;
	}

	public Double getChargePaid() {
		return chargePaid;
	}

	public void setChargePaid(Double chargePaid) {
		this.chargePaid = chargePaid;
	}

	public Integer getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(Integer merchantId) {
		this.merchantId = merchantId;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
}
