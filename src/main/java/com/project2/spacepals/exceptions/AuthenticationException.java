package com.project2.spacepals.exceptions;

public class AuthenticationException extends SpacePalsException {
public AuthenticationException(){
    super("Authentication failed!");
}
public AuthenticationException(String message){
    super(message);
}
}
