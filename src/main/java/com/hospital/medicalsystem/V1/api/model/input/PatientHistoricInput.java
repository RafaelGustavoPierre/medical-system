package com.hospital.medicalsystem.V1.api.model.input;

import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
public class PatientHistoricInput {

    @NotNull
    private OffsetDateTime dateAdmission;

    private OffsetDateTime dateDischarge;

    private String status;

    @OneToOne
    private PatientReferenceInput patient;

    @OneToOne
    private WorkerReferenceInput worker;

}
