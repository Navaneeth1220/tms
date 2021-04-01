package com.cg.tms.dto;

import javax.validation.constraints.NotBlank;

public class ChangePackageRequest {

	@NotBlank
	private int packageId;
	@NotBlank
	private String packageName;

	public int getPackageId() {

		return packageId;
	}

	public void setPackageId(int packageId) {

		this.packageId = packageId;
	}

	public String getPackageName() {

		return packageName;
	}

	public void setPackageName(String packageName) {

		this.packageName = packageName;
	}

}
