package com.lekarze.visit_api.exception;

public class DoctorUnavailableException extends RuntimeException {

    public DoctorUnavailableException(String errorMessage) {
        super(errorMessage);
    }
}
