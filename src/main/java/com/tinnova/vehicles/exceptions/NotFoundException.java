package com.tinnova.vehicles.exceptions;

public class NotFoundException extends Exception {
    public NotFoundException() {
        super("Data not found");
    }
}
