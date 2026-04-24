package com.hospital.medicalsystem.V2.domain.model;

import lombok.Getter;

@Getter
public enum HealthInsuranceType {

    PRIVATE("Particular");

    private String name;

    HealthInsuranceType(String name) {
        this.name = name;
    }
}
