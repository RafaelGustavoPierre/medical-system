package com.hospital.medicalsystem.V1.domain.exception;

public class EntityConflictException extends RuntimeException {

    public EntityConflictException(String message) {
        super(message);
    }

}
