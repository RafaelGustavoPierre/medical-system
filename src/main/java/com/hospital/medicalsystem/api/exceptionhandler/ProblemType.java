package com.hospital.medicalsystem.api.exceptionhandler;

import lombok.Getter;

@Getter
public enum ProblemType {

    ENTITY_NOT_FOUND("/entity-not-found", "Entity not found"),
    EXAM_ACTIVE_CONFLICT("/active-exam-conflict", "Active exam conflict");

    private String title;
    private String uri;

    ProblemType(String path, String title) {
        this.uri = "https://medicalsystem.com" + path;
        this.title = title;
    }

}
