package com.cg.tms.dto;

import javax.validation.constraints.NotBlank;

public class AddReport {
    @NotBlank
    private String reportName;

    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

}
