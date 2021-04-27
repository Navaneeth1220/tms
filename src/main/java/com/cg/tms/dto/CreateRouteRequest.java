package com.cg.tms.dto;

import javax.validation.constraints.NotBlank;

public class CreateRouteRequest {
	@NotBlank
	private String routeFrom;
	@NotBlank
	private String routeTo;
	@NotBlank
	private String pickupPoint;
	private double fare;


	public String getRouteFrom() {
		return routeFrom;
	}

	public void setRouteFrom(String routeFrom) {
		this.routeFrom = routeFrom;
	}

	public String getRouteTo() {
		return routeTo;
	}

	public void setRouteTo(String routeTo) {
		this.routeTo = routeTo;
	}

	public String getPickupPoint() {
		return pickupPoint;
	}

	public void setPickupPoint(String pickupPoint) {
		this.pickupPoint = pickupPoint;
	}

	public double getFare() {
		return fare;
	}

	public void setFare(double fare) {
		this.fare = fare;
	}

}
