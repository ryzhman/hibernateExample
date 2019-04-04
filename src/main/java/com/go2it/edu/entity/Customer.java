package com.go2it.edu.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Alex Ryzhkov
 */
@Entity(name = "customer")
public class Customer {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) private int id;
	private java.sql.Date maturity;
	private String ccType;
	private String ccNo;
	private String email;
	private String address;
	private String name;

	public Customer() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getMaturity() {
		return maturity;
	}

	public void setMaturity(Date maturity) {
		this.maturity = maturity;
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

	@Override
	public String toString() {
		return "Customer{" + "id=" + id + ", maturity=" + maturity + ", ccType='" + ccType + '\'' + ", ccNo='"
				+ ccNo + '\'' + ", email='" + email + '\'' + ", address='" + address + '\'' + ", name='"
				+ name + '\'' + '}';
	}
}
