package com.kalinowski.exchange.model;

import com.kalinowski.exchange.validation.SupportedCurrency;
import lombok.*;

import javax.validation.constraints.Min;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Query {

    @SupportedCurrency
    private String from;

    @SupportedCurrency
    private String to;

    @Min(100)
    private int amount;

}
