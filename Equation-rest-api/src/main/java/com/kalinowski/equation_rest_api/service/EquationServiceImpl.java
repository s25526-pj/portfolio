package com.kalinowski.equation_rest_api.service;

import com.kalinowski.equation_rest_api.model.Equation;
import com.kalinowski.equation_rest_api.repository.EquationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EquationServiceImpl implements EquationService {

    private final EquationRepository equationRepository;
    @Override
    public Equation save(Equation equation) {
        equation.setDate(LocalDateTime.now());
        return equationRepository.save(equation);
    }
    @Override
    public List<Equation> findAllByOperator(char operator) {
        return equationRepository.findAllByOperator(operator);
    }
    @Override
    public List<Equation> findAllByMonth(int month) {
        return equationRepository.findAllByMonth(month);
    }
    @Override
    public List<Equation> findAllByDayOfWeek(int dayOfWeek) {
        return equationRepository.findAllByDayOfWeek(dayOfWeek);
    }


}
