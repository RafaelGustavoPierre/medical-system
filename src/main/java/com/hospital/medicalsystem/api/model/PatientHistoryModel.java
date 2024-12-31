package com.hospital.medicalsystem.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PatientHistoryModel {

    private Long id;

    @JsonProperty("dateAdmission")
    private String dateAdmissionString;

    @JsonProperty("dateDischarge")
    private String dateDischargeString;

    private String status;

    private WorkerModel worker;

}
