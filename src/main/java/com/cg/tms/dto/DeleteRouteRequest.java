package com.cg.tms.dto;

import javax.validation.constraints.NotBlank;

public class DeleteRouteRequest {
	@NotBlank
	String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
