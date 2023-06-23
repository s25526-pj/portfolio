package com.kalinowski.equation_rest_api.service;

import com.kalinowski.equation_rest_api.model.Equation;


import java.util.List;

public interface EquationService {

    Equation save(Equation equation);

    List<Equation> findAllByOperator(char operator);

    List<Equation> findAllByMonth(int month);

    List<Equation> findAllByDayOfWeek(int dayOfWeek);

}
