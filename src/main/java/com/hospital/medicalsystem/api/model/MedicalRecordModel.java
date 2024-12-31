package com.hospital.medicalsystem.api.model;

import com.hospital.medicalsystem.domain.model.Patient;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MedicalRecordModel {

    private Patient patient;
    private List<HospitalizationHistoryModel> hospitalizationHistory;

}
