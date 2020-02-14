package com.project2.spacepals.exceptions;

public class BadRequestException extends SpacePalsException {
    public BadRequestException(){
        super("An invalid request was made!");
    }
    public BadRequestException(String message) {
        super(message);
    }
}
