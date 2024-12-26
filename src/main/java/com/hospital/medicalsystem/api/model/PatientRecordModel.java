package com.hospital.medicalsystem.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatientRecordModel {

    private WorkerModel worker;
    private String observation;

}
