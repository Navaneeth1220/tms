package com.cg.tms.dto;

import javax.validation.constraints.NotBlank;

public class DeletePackageRequest {

	@NotBlank
	private int packageId;

	public int getPackageId() {

		return packageId;
	}

	public void setPackageId(int packageId) {

		this.packageId = packageId;
	}

}
