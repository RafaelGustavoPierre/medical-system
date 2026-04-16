package com.hospital.medicalsystem.V2.domain.exception;

public class ConflictException extends RuntimeException {
    public ConflictException(String message) {
        super(message);
    }
}
