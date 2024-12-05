package com.hospital.medicalsystem.domain.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PatientHistoric {

    private Patient patient;
    private List<ExamRegistred> examRegistred;
    private List<RemedieRegistred> remedieRegistred;

}
