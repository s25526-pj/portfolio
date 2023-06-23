package com.kalinowski.exchange.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
@Setter
public class ExchangeApiResponse {

    private boolean success;
    private Query query;
    private Info info;
    private String date;
    private BigDecimal result;
}
