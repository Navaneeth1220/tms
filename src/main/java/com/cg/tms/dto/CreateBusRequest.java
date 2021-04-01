package com.cg.tms.dto;

import javax.validation.constraints.NotBlank;

public class CreateBusRequest {

	private int busId;
	@NotBlank
	private String busType;
	@NotBlank
	private String busNumber;
	@NotBlank
	private int capacity;

	public int getBusId() {
		return busId;
	}

	public void setBusId(int busId) {
		this.busId = busId;
	}

	public String getBusType() {
		return busType;
	}

	public void setBusType(String busType) {
		this.busType = busType;
	}

	public String getBusNumber() {
		return busNumber;
	}

	public void setBusNumber(String busNumber) {
		this.busNumber = busNumber;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
}
