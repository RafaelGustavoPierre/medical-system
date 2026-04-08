package com.hospital.medicalsystem.V1.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatientRecordModel {

    private WorkerModel worker;
    private String observation;

}
