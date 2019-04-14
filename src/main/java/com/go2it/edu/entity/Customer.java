package com.go2it.edu.entity;

import java.sql.Date;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 * @author Alex Ryzhkov
 */
@Entity(name = "customer")
public class Customer {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) private int id;
	@Column(name = "maturity")
	private java.sql.Date expDate;
	private String ccType;
	private String ccNo;
	private String email;
	private String address;
	private String name;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="Payment", joinColumns=@JoinColumn(name="customerId"),
			inverseJoinColumns=@JoinColumn(name="merchantId"))
	private Collection<Merchant> merchants;
	@OneToMany(mappedBy = "customer", cascade=CascadeType.ALL)
	private List<Payment> payment;

	public Customer() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getExpDate() {
		return expDate;
	}

	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}

	public String getCcType() {
		return ccType;
	}

	public void setCcType(String ccType) {
		this.ccType = ccType;
	}

	public String getCcNo() {
		return ccNo;
	}

	public void setCcNo(String ccNo) {
		this.ccNo = ccNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Collection<Merchant> getMerchants() {
		return merchants;
	}

	public void setMerchants(Collection<Merchant> merchants) {
		this.merchants = merchants;
	}

	public List<Payment> getPayment() {
		return payment;
	}

	public void setPayment(List<Payment> payment) {
		this.payment = payment;
	}

	@Override
	public String toString() {
		return "Customer{" + "id=" + id + ", expDate=" + expDate + ", ccType='" + ccType + '\'' + ", ccNo='"
				+ ccNo + '\'' + ", email='" + email + '\'' + ", address='" + address + '\'' + ", name='"
				+ name + '\'' + '}';
	}
}
