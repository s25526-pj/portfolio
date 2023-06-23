package com.kalinowski.equation_rest_api.strategy;

import com.kalinowski.equation_rest_api.model.command.CreateEquationCommand;
import com.kalinowski.equation_rest_api.model.Result;

public interface ResultCreateStrategy {

    Result create(CreateEquationCommand command);

}
