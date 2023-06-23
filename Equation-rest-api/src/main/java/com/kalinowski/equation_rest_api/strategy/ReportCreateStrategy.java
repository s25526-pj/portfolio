package com.kalinowski.equation_rest_api.strategy;

import com.kalinowski.equation_rest_api.model.report.Report;

public interface ReportCreateStrategy {

    Report create(String type);

}
