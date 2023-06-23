package com.kalinowski.exchange.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = SupportedCurrencyValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface SupportedCurrency {

    String message() default "Currency not supported";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
