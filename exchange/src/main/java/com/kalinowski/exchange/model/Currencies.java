package com.kalinowski.exchange.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@AllArgsConstructor
@Getter
@Setter
public class Currencies {

    private boolean success;
    private Map<String, String> symbols;

}
