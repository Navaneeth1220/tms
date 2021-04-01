package com.cg.tms.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cg.tms.dto.ReportDetails;
import com.cg.tms.entities.Report;

@Component
public class ReportUtil {
	// public Report newReport() {
	// return new Report();
	public ReportDetails toReportDetail(Report report) {
		ReportDetails reportDetails = new ReportDetails();
		reportDetails.setReportId(report.getReportId());
		reportDetails.setReportName(report.getReportName());
		reportDetails.setReportType(report.getReportType());

		return reportDetails;
	}

	public List<ReportDetails> toReportDetail(Collection<Report> reports) {
		List<ReportDetails> desired = new ArrayList<>();
		for (Report report : reports) {

			ReportDetails reportDetails = toReportDetail(report);
			desired.add(reportDetails);
		}

		return desired;

	}
}
