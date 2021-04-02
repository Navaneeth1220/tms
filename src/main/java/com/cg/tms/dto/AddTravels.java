package com.cg.tms.dto;

import javax.validation.constraints.NotBlank;

public class AddTravels {
	@NotBlank
	private String travelsName;
	@NotBlank
	private String agentName;
	@NotBlank
	private String address;
	@NotBlank
	private String contact;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getTravelsName() {
		return travelsName;
	}

	public void setTravelsName(String travelsName) {
		this.travelsName = travelsName;
	}

	public String getAgentName() {
		return agentName;
	}

	public void setAgentName(String agentsName) {
		this.agentName = agentsName;
	}

}