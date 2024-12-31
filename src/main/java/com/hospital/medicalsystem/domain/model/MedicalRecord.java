package com.hospital.medicalsystem.domain.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MedicalRecord {

    private Patient patient;
    private List<HospitalizationHistory> hospitalizationHistory;

}