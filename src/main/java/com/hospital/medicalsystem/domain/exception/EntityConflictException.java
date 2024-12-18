package com.hospital.medicalsystem.domain.exception;

public class EntityConflictException extends RuntimeException {

    public EntityConflictException(String message) {
        super(message);
    }

}
