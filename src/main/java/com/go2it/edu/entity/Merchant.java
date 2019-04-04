package com.go2it.edu.entity;

import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * @author Alex Ryzhkov
 */
@Entity(name = "merchant")
public class Merchant {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) private int id;
	private String name;
	private String bankName;
	private String swift;
	private String account;
	private Double charge;
	private Short period;
	private Double minSum;
	private Double needToSend;
	private Double sent;
	private java.sql.Date lastSent;
	@OneToMany(mappedBy = "merchant", fetch = FetchType.EAGER)
	private Collection<Payment> payments;

	public Merchant() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getSwift() {
		return swift;
	}

	public void setSwift(String swift) {
		this.swift = swift;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public Double getCharge() {
		return charge;
	}

	public void setCharge(Double charge) {
		this.charge = charge;
	}

	public Short getPeriod() {
		return period;
	}

	public void setPeriod(Short period) {
		this.period = period;
	}

	public Double getMinSum() {
		return minSum;
	}

	public void setMinSum(Double minSum) {
		this.minSum = minSum;
	}

	public Double getNeedToSend() {
		return needToSend;
	}

	public void setNeedToSend(Double needToSend) {
		this.needToSend = needToSend;
	}

	public Double getSent() {
		return sent;
	}

	public void setSent(Double sent) {
		this.sent = sent;
	}

	public Date getLastSent() {
		return lastSent;
	}

	public void setLastSent(Date lastSent) {
		this.lastSent = lastSent;
	}

	public Collection<Payment> getPayments() {
		return payments;
	}

	public void setPayments(Collection<Payment> payments) {
		this.payments = payments;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Merchant merchant = (Merchant) o;
		return id == merchant.id && Objects.equals(name, merchant.name) && Objects.equals(bankName,
				merchant.bankName) && Objects.equals(swift, merchant.swift) && Objects.equals(account,
				merchant.account) && Objects.equals(charge, merchant.charge) && Objects.equals(period,
				merchant.period) && Objects.equals(minSum, merchant.minSum) && Objects.equals(needToSend,
				merchant.needToSend) && Objects.equals(sent, merchant.sent) && Objects.equals(lastSent,
				merchant.lastSent);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, bankName, swift, account, charge, period, minSum, needToSend, sent,
				lastSent);
	}
}
