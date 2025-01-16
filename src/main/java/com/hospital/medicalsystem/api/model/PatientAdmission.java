package com.hospital.medicalsystem.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatientAdmission {

    private PatientModel patient;
    private PatientHistoricModel patientHistoric;

}
