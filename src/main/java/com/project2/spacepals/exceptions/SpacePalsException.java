package com.project2.spacepals.exceptions;

public class SpacePalsException extends RuntimeException {
public SpacePalsException(String message){super(message);}
public SpacePalsException(String message, Throwable cause){
    super(message, cause);
}
public SpacePalsException(Throwable cause){
    super(cause);
}
}

