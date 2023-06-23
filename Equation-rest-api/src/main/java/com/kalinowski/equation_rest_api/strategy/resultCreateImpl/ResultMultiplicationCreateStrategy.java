package com.kalinowski.equation_rest_api.strategy.resultCreateImpl;

import com.kalinowski.equation_rest_api.model.command.CreateEquationCommand;
import com.kalinowski.equation_rest_api.model.Result;
import com.kalinowski.equation_rest_api.strategy.ResultCreateStrategy;
import org.springframework.stereotype.Component;

@Component("*")
public class ResultMultiplicationCreateStrategy implements ResultCreateStrategy {

    @Override
    public Result create(CreateEquationCommand command) {
        double result = command.getNum1() * command.getNum2();
        return Result.builder()
                .result(result)
                .build();
    }
}
