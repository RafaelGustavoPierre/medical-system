package com.hospital.medicalsystem.api.model;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class PatientExamRegistredModel {

    private PatientModel patient;
    private ExamRegistredModel exam;

}
