package com.kalinowski.equation_rest_api.service;

import com.kalinowski.equation_rest_api.model.report.Report;
import com.kalinowski.equation_rest_api.strategy.ReportCreateStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService {


    private final Map<String, ReportCreateStrategy> strategyMap;

    public Report getReport(String type) {
        ReportCreateStrategy strategy = strategyMap.get(type);
        return strategy.create(type);
    }

}

