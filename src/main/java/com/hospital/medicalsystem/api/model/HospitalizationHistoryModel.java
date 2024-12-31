package com.hospital.medicalsystem.api.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class HospitalizationHistoryModel {

    private PatientHistoryModel patientHistory;
    private PatientRecordModel patientRecord;
    private List<RemedieRegistredModel> remedieRegistred;
    private List<ExamRegistredModel> examRegistred;

}
