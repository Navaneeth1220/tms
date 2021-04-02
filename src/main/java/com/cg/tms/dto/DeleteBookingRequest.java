package com.cg.tms.dto;

import javax.validation.constraints.NotBlank;

public class DeleteBookingRequest {
	@NotBlank
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
