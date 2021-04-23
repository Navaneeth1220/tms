package com.cg.tms.service;

import java.time.LocalDate;
import java.util.List;

import com.cg.tms.entities.Report;
import com.cg.tms.exceptions.ReportNotFoundException;

public interface IReportService {


    Report addReport(Report report);

    Report deleteReport(int reportId) throws ReportNotFoundException;

    Report viewReport(int reportId) throws ReportNotFoundException;

    List<Report> viewAllReports();



}
