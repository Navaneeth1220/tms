package com.cg.tms.dto;


public class CreateBookingRequest {

	private String bookingType;
	private String bookingTitle;
	private String description;
	private int userId;
	private int packageId;
	private String packageName;
	private String packageType;
	private String packageDescription;
	private double cost;
	

	public String getBookingType() {
		return bookingType;
	}

	public void setBookingType(String bookingType) {
		this.bookingType = bookingType;
	}

	public String getBookingTitle() {
		return bookingTitle;
	}

	public void setBookingTitle(String bookingTitle) {
		this.bookingTitle = bookingTitle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	

}
