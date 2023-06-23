package com.kalinowski.equation_rest_api.configuration;

import com.kalinowski.equation_rest_api.mapper.EquationMapper;
import com.kalinowski.equation_rest_api.mapper.EquationMapperImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapstructConfiguration {

    @Bean
    public EquationMapper equationMapper() {
        return new EquationMapperImpl();
    }

}
