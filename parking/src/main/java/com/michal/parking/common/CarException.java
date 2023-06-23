package com.michal.parking.common;

public class CarException extends RuntimeException {
    public CarException(String errorMessage) {
        super(errorMessage);
    }
}
