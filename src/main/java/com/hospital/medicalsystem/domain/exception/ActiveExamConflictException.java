package com.hospital.medicalsystem.domain.exception;

public class ActiveExamConflictException extends RuntimeException {

    public ActiveExamConflictException(String message) {
        super(message);
    }

}
