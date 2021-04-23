package com.cg.tms.dto;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

public class ReportDetails {
	@NotBlank
	private int reportId;
	private String reportType;
	private String reportName;

	private int bookingsCount;

	// total earning on that day
	private double earning;

	public int getReportId() {
		return reportId;
	}

	public void setReportId(int reportId) {
		this.reportId = reportId;
	}

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

	public int getBookingsCount() {
		return bookingsCount;
	}

	public void setBookingsCount(int bookingsCount) {
		this.bookingsCount = bookingsCount;
	}

	public double getEarning() {
		return earning;
	}

	public void setEarning(double earning) {
		this.earning = earning;
	}
}
