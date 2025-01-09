package com.hospital.medicalsystem.domain.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class HospitalizationHistoric {

    private PatientHistoric patientHistoric;
    private PatientRecord patientRecord;
    private List<RemedieRegistred> remedieRegistred;
    private List<ExamRegistred> examRegistred;

}
