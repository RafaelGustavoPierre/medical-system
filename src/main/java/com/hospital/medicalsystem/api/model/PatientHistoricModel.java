package com.hospital.medicalsystem.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatientHistoricModel {

    private Long id;

    @JsonProperty("dateAdmission")
    private String dateAdmissionString;

    @JsonProperty("dateDischarge")
    private String dateDischargeString;

    private String status;

    private WorkerModel worker;

}
