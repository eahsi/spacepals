package com.project2.spacepals.exceptions;

public class AuthorizationException extends SpacePalsException {
    public AuthorizationException(){
        super("Requester lacks the proper authorities to perform that action!");
    }
    public AuthorizationException(String message) {
        super(message);
    }
}
