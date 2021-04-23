package com.cg.tms.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Report {
	@GeneratedValue
	@Id
	private int reportId;
	
	private String reportName;
	private String reportType;
	//number of bookings on a day
	private int bookingsCount;
	//report's date
	@Column(nullable = false, unique = true)
	private LocalDate reportDate;
	// total earning on that day
	private double earning;

	public Report() {
	}

	public Report (String reportName, String reportType) {
		this.reportName = reportName;
		this.reportType = reportType;
	}
	
	public int getReportId() {
		return reportId;
	}
	public void setReportId(int reportid) {
		this.reportId = reportid;
	}
	public String getReportName() {
		return reportName;
	}
	public void setReportName(String reportname) {
		this.reportName = reportname;
	}
	public String getReportType() {
		return reportType;
	}
	public void setReportType(String reporttype) {
		this.reportType = reporttype;
	}

	public int getBookingsCount() {
		return bookingsCount;
	}

	public void setBookingsCount(int bookingsCount) {
		this.bookingsCount = bookingsCount;
	}

	public LocalDate getReportDate() {
		return reportDate;
	}

	public void setReportDate(LocalDate reportDate) {
		this.reportDate = reportDate;
	}

	public double getEarning() {
		return earning;
	}

	public void setEarning(double earning) {
		this.earning = earning;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Report report = (Report) o;
		return reportId == report.reportId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(reportId);
	}
}
