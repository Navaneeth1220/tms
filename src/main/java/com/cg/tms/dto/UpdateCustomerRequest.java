package com.cg.tms.dto;

import javax.validation.constraints.NotBlank;

public class UpdateCustomerRequest {
	@NotBlank
	private String customerName;
	@NotBlank
	private String address;
	@NotBlank
	private String mobileNo;
	@NotBlank
	private String email;
	@NotBlank
	private String customerPassword;

	public String getCustomerPassword() {
		return customerPassword;
	}

	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
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
