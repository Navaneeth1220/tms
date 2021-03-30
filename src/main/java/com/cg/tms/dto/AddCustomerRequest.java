package com.cg.tms.dto;

public class AddCustomerRequest {
	private int customerId;
    private String customerName;
    private String customerPassword;
    private String address;
    private String mobileNo;
    private String email;
    
    public int CustomerId() {

		return customerId;
	}

	public void setCustomerId(int customerId) {

		this.customerId = customerId;
	}

	public String CustomerName() {

		return customerName;
	}

	public void setCustomerName(String customerName) {

		this.customerName = customerName;
	}
	
	public String CustomerPassword() {

		return customerPassword;
	}
	public void setCustomerPassword(String customerPassword) {

		this.customerPassword = customerPassword;
	}
	
	public String CustomerAddress() {

		return address;
	}
	public void setCustomerAddress(String address) {

		this.address = address;
	}
	
	public String CustomerMobileNo() {

		return mobileNo;
	}
	public void setCustomerMobileNo(String mobileNo) {

		this.mobileNo = mobileNo;
	}
	
	public String CustomerEmail() {

		return email;
	}
	public void setCustomerEmail(String email) {

		this.email = email;
	}

}
