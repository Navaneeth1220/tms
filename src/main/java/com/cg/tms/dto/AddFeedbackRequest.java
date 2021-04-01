package com.cg.tms.dto;

import com.cg.tms.entities.Customer;

public class AddFeedbackRequest {

	private int  customerId;
	private String feedback;
	private int rating;

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
}
