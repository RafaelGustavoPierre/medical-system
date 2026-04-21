package com.hospital.medicalsystem.V2.domain.model;

import lombok.Getter;

@Getter
public enum ExamRegistered {

    PARTICULAR("Particular");

    private String name;

    ExamRegistered(String name) {
        this.name = name;
    }
}
