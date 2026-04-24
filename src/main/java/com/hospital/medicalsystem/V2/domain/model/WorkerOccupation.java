package com.hospital.medicalsystem.V2.domain.model;

import lombok.Getter;

@Getter
public enum WorkerOccupation {

    DOCTOR(1L,"Doctor"),
    NURSE(1L,"Nurse");

    private Long departmentId;
    private String name;

    WorkerOccupation(Long departmentId, String name) {
        this.departmentId = departmentId;
        this.name = name;
    }
}
