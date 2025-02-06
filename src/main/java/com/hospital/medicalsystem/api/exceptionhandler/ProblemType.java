package com.hospital.medicalsystem.api.exceptionhandler;

import lombok.Getter;

@Getter
public enum ProblemType {

    SYSTEM_ERROR("/system-error", "System erro"),
    ENTITY_NOT_FOUND("/entity-not-found", "Entity not found"),
    INVALID_DATA("/invalid-data", "Invalid data"),
    SYNTAX_ERROR("/syntax-error", "Syntax error"),
    INVALID_PARAM("/invalid-param", "Invalid param"),
    EXAM_ACTIVE_CONFLICT("/active-exam-conflict", "Active exam conflict");

    private String title;
    private String uri;

    ProblemType(String path, String title) {
        this.uri = "https://medicalsystem.com" + path;
        this.title = title;
    }

}
