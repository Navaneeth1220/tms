package com.cg.tms.dto;

import javax.validation.constraints.NotBlank;

import com.cg.tms.entities.Package;
import com.cg.tms.entities.Route;

public class CustomerDetails {
	@NotBlank
	private int customerId;
	@NotBlank
	private String customerName;
	@NotBlank
	private String customerPassword;
	@NotBlank
	private String address;
	@NotBlank
	private String mobileNo;
	@NotBlank
	private String email;

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerPassword() {
		return customerPassword;
	}

	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}