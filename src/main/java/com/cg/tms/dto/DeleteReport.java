package com.cg.tms.dto;

import javax.validation.constraints.NotBlank;

public class DeleteReport {
	@NotBlank
	private int reportId;

	public int getReportId() {
		return reportId;
	}

	public void setReportId(int reportId) {
		this.reportId = reportId;
	}

}
