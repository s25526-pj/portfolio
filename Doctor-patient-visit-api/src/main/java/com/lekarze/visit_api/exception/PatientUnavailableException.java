package com.lekarze.visit_api.exception;

public class PatientUnavailableException extends RuntimeException {

    public PatientUnavailableException(String errorMessage) {
        super(errorMessage);
    }

}
