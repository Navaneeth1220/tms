package com.cg.tms.dto;

import javax.validation.constraints.NotBlank;

public class AddReport {
	@NotBlank
	private String reportType;
	@NotBlank
	private String reportName;
	public String getReportType() {
		return reportType;
	}
	public void setReportType(String reportType) {
		this.reportType = reportType;
	}
	public String getReportName() {
		return reportName;
	}
	public void setReportName(String reportName) {
		this.reportName = reportName;
	}

}
