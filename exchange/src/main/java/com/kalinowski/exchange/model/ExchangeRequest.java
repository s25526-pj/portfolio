package com.kalinowski.exchange.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Pattern;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ExchangeRequest extends Query {

    @Pattern(regexp = "[a-z0-9]+?.[a-z0-9]+@[a-z]+\\.[a-z]{2,3}")
    private String reciverEmail;

}
