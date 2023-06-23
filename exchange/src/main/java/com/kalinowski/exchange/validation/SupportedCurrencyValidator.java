package com.kalinowski.exchange.validation;

import com.kalinowski.exchange.model.Currencies;
import lombok.RequiredArgsConstructor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@RequiredArgsConstructor
public class SupportedCurrencyValidator implements ConstraintValidator<SupportedCurrency, String> {

    private final Currencies currencies;

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return currencies.getSymbols().containsKey(s);
    }
}
