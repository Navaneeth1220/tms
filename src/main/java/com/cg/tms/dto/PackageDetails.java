package com.cg.tms.dto;

import javax.validation.constraints.NotBlank;

public class PackageDetails {

	private int packageId;
	private String packageName;
	private String packageDescription;
	private String packageType;
	private double packageCost;
	private int hotelId;
	private String hotelName;
	private String hotelType;
	private String hotelDescription;
	private String address;
	private double rent;
	private String hotelStatus;

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

	public int getHotelId() {

		return hotelId;
	}

	public void setHotelId(int hotelId) {

		this.hotelId = hotelId;
	}

	public String getHotelName() {

		return hotelName;
	}

	public void setHotelName(String hotelName) {

		this.hotelName = hotelName;
	}

	public String getHotelType() {

		return hotelType;
	}

	public void setHotelType(String hotelType) {

		this.hotelType = hotelType;
	}

	public String getHotelDescription() {

		return hotelDescription;
	}

	public void setHotelDescription(String hotelDescription) {

		this.hotelDescription = hotelDescription;
	}

	public String getAddress() {

		return address;
	}

	public void setAddress(String address) {

		this.address = address;
	}

	public double getRent() {

		return rent;
	}

	public void setRent(double rent) {

		this.rent = rent;
	}

	public String getHotelStatus() {

		return hotelStatus;
	}

	public void setHotelStatus(String hotelStatus) {

		this.hotelStatus = hotelStatus;
	}

}
