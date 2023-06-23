package com.kalinowski.equation_rest_api.strategy.reportCreateImpl;

import com.kalinowski.equation_rest_api.model.report.Report;
import com.kalinowski.equation_rest_api.model.report.ReportPerDayOfWeek;
import com.kalinowski.equation_rest_api.service.EquationServiceImpl;
import com.kalinowski.equation_rest_api.strategy.ReportCreateStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component("PER_DAY_OF_WEEK")
@RequiredArgsConstructor
public class ReportPerDayOfWeekCreateStrategy implements ReportCreateStrategy {

    private final EquationServiceImpl equationServiceImpl;

    @Override
    public Report create(String type) {
        return ReportPerDayOfWeek.builder()
                .type(type)
                .monday(equationServiceImpl.findAllByDayOfWeek(1).size())
                .tuesday(equationServiceImpl.findAllByDayOfWeek(2).size())
                .wednesday(equationServiceImpl.findAllByDayOfWeek(3).size())
                .thursday(equationServiceImpl.findAllByDayOfWeek(4).size())
                .friday(equationServiceImpl.findAllByDayOfWeek(5).size())
                .saturday(equationServiceImpl.findAllByDayOfWeek(6).size())
                .sunday(equationServiceImpl.findAllByDayOfWeek(7).size())
                .build();
    }
}
