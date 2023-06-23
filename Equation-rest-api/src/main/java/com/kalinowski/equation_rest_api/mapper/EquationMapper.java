package com.kalinowski.equation_rest_api.mapper;

import com.kalinowski.equation_rest_api.model.Equation;
import com.kalinowski.equation_rest_api.model.command.CreateEquationCommand;
import org.mapstruct.Mapper;

@Mapper
public interface EquationMapper {

    Equation equationMapFromCreateCommand(CreateEquationCommand source);

}
