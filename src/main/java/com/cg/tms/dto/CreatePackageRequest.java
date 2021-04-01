package com.cg.tms.dto;

import javax.validation.constraints.NotBlank;

public class CreatePackageRequest {

	@NotBlank
	private String packageName;
	@NotBlank
	private String packageDescription;
	@NotBlank
	private String packageType;
	@NotBlank
	private double packageCost;

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {

		this.packageName = packageName;
	}

	public String getPackageDescription() {

		return packageDescription;
	}

	public void setPackageDescription(String packageDescription) {

		this.packageDescription = packageDescription;
	}

	public String getPackageType() {

		return packageType;
	}

	public void setPackageType(String packageType) {

		this.packageType = packageType;
	}

	public double getPackageCost() {

		return packageCost;
	}

	public void setPackageCost(double packageCost) {

		this.packageCost = packageCost;
	}

}
