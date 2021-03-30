package com.cg.tms.dto;

import com.cg.tms.entities.Customer;

public class AddFeedbackRequest {

	private int feedbackId;
	private Customer customer;
	private String feedback;
	private int rating;

	public int getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
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

	public String getfeedback() {
		return feedback;
	}

	public void setfeedback(String feedback) {
		this.feedback = feedback;
	}

	public int getrating() {
		return rating;
	}

	public void setrating(int rating) {
		this.rating = rating;
	}

}
