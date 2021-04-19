package com.cg.tms.entities;

import java.util.Objects;
import javax.persistence.*;

@Entity
public class Package {

	@GeneratedValue
	@Id
	private int packageId;
	private String packageName;
	private String packageDescription;
	private String packageType;
	private double packageCost;

	@ManyToOne
	private Hotel hotel;

	public Package() {

	}

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


	public Hotel getHotel() {

		return hotel;
	}

	public void setHotel(Hotel hotel) {

		this.hotel = hotel;
	}

	@Override
	public String toString() {

		return "Package [packageId=" + packageId + ", packageName=" + packageName + ", packageDescription="
				+ packageDescription + ", packageType=" + packageType + ", packageCost=" + packageCost + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Package other = (Package) obj;
		if (packageId != other.packageId)
			return false;
		return true;
	}

	@Override
	public int hashCode() {

		return Objects.hash(packageId);
	}

}
