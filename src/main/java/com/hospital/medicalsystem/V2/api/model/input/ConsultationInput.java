package com.hospital.medicalsystem.V2.api.model.input;

import com.hospital.medicalsystem.V2.api.model.input.reference.HealthInsuranceIdReferenceInput;
import com.hospital.medicalsystem.V2.api.model.input.reference.PatientCpfReferenceInput;
import com.hospital.medicalsystem.V2.api.model.input.reference.WorkerIdReferenceInput;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConsultationInput {

    @NotNull
    private PatientCpfReferenceInput patient;

    @NotNull
    private HealthInsuranceIdReferenceInput healthInsurance;

    @NotNull
    private WorkerIdReferenceInput worker;

    private String observation;

}
