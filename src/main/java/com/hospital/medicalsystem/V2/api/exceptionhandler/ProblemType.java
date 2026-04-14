package com.hospital.medicalsystem.V2.api.exceptionhandler;

import lombok.Getter;

@Getter
public enum ProblemType {

    RESOURCE_NOT_FOUND("/resource-not-found", "Recurso não encontrado");

    private String title;
    private String uri;

    ProblemType(String path, String title) {
        this.uri = "https://medicalsystem.com" + path;
        this.title = title;
    }

}
