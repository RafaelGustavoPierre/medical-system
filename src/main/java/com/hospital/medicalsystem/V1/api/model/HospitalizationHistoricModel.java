package com.hospital.medicalsystem.V1.api.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class HospitalizationHistoricModel {

    private PatientHistoricModel patientHistoric;
    private PatientRecordModel patientRecord;
    private List<RemedieRegistredModel> remedieRegistred;
    private List<ExamRegistredModel> examRegistred;

}
