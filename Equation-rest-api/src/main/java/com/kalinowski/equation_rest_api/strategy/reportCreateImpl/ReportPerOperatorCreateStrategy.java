package com.kalinowski.equation_rest_api.strategy.reportCreateImpl;

import com.kalinowski.equation_rest_api.model.report.Report;
import com.kalinowski.equation_rest_api.model.report.ReportPerOperator;
import com.kalinowski.equation_rest_api.service.EquationServiceImpl;
import com.kalinowski.equation_rest_api.strategy.ReportCreateStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component("PER_OPERATOR")
@RequiredArgsConstructor
public class ReportPerOperatorCreateStrategy implements ReportCreateStrategy {

    private final EquationServiceImpl equationServiceImpl;

    @Override
    public Report create(String type) {
        return ReportPerOperator.builder()
                .type(type)
                .plus(equationServiceImpl.findAllByOperator('+').size())
                .minus(equationServiceImpl.findAllByOperator('-').size())
                .divide(equationServiceImpl.findAllByOperator('/').size())
                .multiply(equationServiceImpl.findAllByOperator('*').size())
                .build();
    }

}
