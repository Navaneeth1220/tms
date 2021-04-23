package com.cg.tms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.tms.entities.Report;

import java.time.LocalDate;

public interface IReportRepository extends JpaRepository<Report, Integer> {

    Report findReportByReportDate(LocalDate date);

    boolean existsByReportDate(LocalDate date);
}
