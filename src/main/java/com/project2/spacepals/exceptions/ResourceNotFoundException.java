package com.project2.spacepals.exceptions;

public class ResourceNotFoundException extends SpacePalsException {
    public ResourceNotFoundException(){
        super("No resource found with provided search critera!");
    }
    public ResourceNotFoundException(String message) {

        super(message);
    }

   }

