package com.hospital.medicalsystem.api.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PatientHistoricModel {

    private PatientModel patient;
    private List<ExamRegistredModel> examRegistred;
    private List<RemedieRegistredModel> remedieRegistred;

}
