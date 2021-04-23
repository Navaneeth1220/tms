package com.cg.tms.service;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.cg.tms.entities.Booking;
import com.cg.tms.entities.PaymentDetails;
import com.cg.tms.exceptions.AddReportException;
import com.cg.tms.repository.IBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.tms.entities.Report;
import com.cg.tms.exceptions.InvalidIdException;
import com.cg.tms.exceptions.InvalidReportException;
import com.cg.tms.exceptions.ReportNotFoundException;
import com.cg.tms.repository.IReportRepository;

@Service
public class ReportService implements IReportService {

    @Autowired
    private IReportRepository reportRepository;

    @Autowired
    private IBookingRepository bookingRepository;


    @Override
    public Report addReport(Report report) {
        validateReportType(report.getReportType());
        validateReportName(report.getReportName());
        report.setReportType("daily");
        LocalDate todayDate = currentDate();
        boolean exists = reportRepository.existsByReportDate(todayDate);
        if(exists){
            throw new AddReportException("report already exists for the day");
        }
        List<Booking> bookings = bookingRepository.findByBookingDate(todayDate);
        report.setBookingsCount(bookings.size());
        report.setReportDate(todayDate);
        double total = totalEarning(bookings);
        report.setEarning(total);
        return reportRepository.save(report);
    }


    public double totalEarning(Collection<Booking> bookings) {
        if (bookings == null) {
            return 0;
        }
        double total = 0;
        for (Booking booking : bookings) {
            PaymentDetails paymentDetails = booking.getPayment();
            total = total + paymentDetails.getNetAmount();
        }
        return total;
    }

    LocalDate currentDate() {
        return LocalDate.now();
    }


    void validateReportName(String reportName) {
        if (reportName == null || reportName.isEmpty() || reportName.trim().isEmpty()) {
            throw new InvalidReportException("Check Report Name");
        }

    }

    void validateReportType(String reportType) {
        if (reportType == null || reportType.isEmpty() || reportType.trim().isEmpty()) {
            throw new InvalidReportException("Check Report Type");
        }

    }

    @Override
    public Report deleteReport(int reportId) throws ReportNotFoundException {
        validateId(reportId);
        Optional<Report> optional = reportRepository.findById(reportId);
        if (!optional.isPresent()) {
            throw new ReportNotFoundException("Report not found");
        }
        Report fetched = optional.get();
        reportRepository.delete(fetched);
        return fetched;

    }

    void validateId(int reportId) {
        if (reportId < 0) {
            throw new InvalidIdException("ID cannot be negative");
        }

    }

    @Override
    public Report viewReport(int reportId) throws ReportNotFoundException {
        Optional<Report> optional = reportRepository.findById(reportId);
        if (!optional.isPresent()) {
            throw new ReportNotFoundException("Report not found");
        }
        return optional.get();
    }

    @Override
    public List<Report> viewAllReports() {
        List<Report> reports = reportRepository.findAll();
        return reports;
    }

}
