package com.cg.tms.dto;

import javax.validation.constraints.NotBlank;

public class AddFeedbackRequest {
    @NotBlank
	private int  customerId;
    @NotBlank
	private String feedback;
    @NotBlank
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
