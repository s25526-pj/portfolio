package com.kalinowski.equation_rest_api.service;

import com.kalinowski.equation_rest_api.model.report.Report;

public interface ReportService {

    Report getReport(String type);

}
