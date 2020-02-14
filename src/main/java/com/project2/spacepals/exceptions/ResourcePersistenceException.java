package com.project2.spacepals.exceptions;

public class ResourcePersistenceException extends SpacePalsException {
    public ResourcePersistenceException(String message) {
        super(message);
    }

    public ResourcePersistenceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ResourcePersistenceException() {
        super("Resource could not be persisted!");
    }
}
