package com.cg.tms.controllers;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import com.cg.tms.service.IBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.tms.dto.AddReport;

import com.cg.tms.dto.DeleteReport;
import com.cg.tms.dto.ReportDetails;

import com.cg.tms.entities.Report;
import com.cg.tms.service.IReportService;

import com.cg.tms.util.ReportUtil;

@Validated
@RequestMapping("/reports")
@RestController
public class ReportRestController {
    @Autowired
    private IReportService reportService;

    @Autowired
    private IBookingService bookingService;


    @Autowired
    private ReportUtil util;

    @PostMapping("/add")
    public ReportDetails createReport(@RequestBody @Valid AddReport requestData) {
        Report report = new Report();
        report.setReportName(requestData.getReportName());
        Report added = reportService.addReport(report);
        ReportDetails details = util.toReportDetail(added);
        return details;
    }


    @GetMapping("/byid/{id}")
    public ReportDetails viewReport(@PathVariable("id") @Min(1) int id) {
        Report report = reportService.viewReport(id);
        ReportDetails fetched = util.toReportDetail(report);
        return fetched;
    }

    @GetMapping
    public List<ReportDetails> allReport() {
        List<Report> viewing = reportService.viewAllReports();
        List<ReportDetails> view = util.toReportDetail(viewing);
        return view;
    }

    @DeleteMapping("/delete")
    public void deleteReport(@RequestBody @Valid DeleteReport requestData) {
        reportService.deleteReport(requestData.getReportId());
        // return "Report delete for id "+requestData.getId();
    }

}
