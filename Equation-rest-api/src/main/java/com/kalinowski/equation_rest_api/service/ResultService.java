package com.kalinowski.equation_rest_api.service;

import com.kalinowski.equation_rest_api.model.Result;
import com.kalinowski.equation_rest_api.model.command.CreateEquationCommand;

public interface ResultService {


    Result getEquationResult(CreateEquationCommand command);

}
