package com.kalinowski.exchange.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
@Setter
public class Info {

    private String timestamp;
    private BigDecimal rate;

}
