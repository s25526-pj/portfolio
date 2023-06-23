package com.michal.parking.common;

public class ParkingException extends RuntimeException{

    public ParkingException(String errorMessage) {
        super(errorMessage);
    }

}
