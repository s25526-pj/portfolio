package com.kalinowski.equation_rest_api.model.command;

import com.kalinowski.equation_rest_api.validation.ValidOperator;
import lombok.Data;

@Data
public class CreateEquationCommand {

    private double num1;
    private double num2;
    @ValidOperator
    private char operator;

}
