package com.hospital.medicalsystem.V2.api.model.input;

import com.hospital.medicalsystem.V2.api.model.input.reference.HealthInsuranceIdReferenceInput;
import com.hospital.medicalsystem.V2.api.model.input.reference.PatientIdReferenceInput;
import com.hospital.medicalsystem.V2.api.model.input.reference.WorkerIdReferenceInput;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@ToString
@Getter
@Setter
public class ExamRegistredReferenceInput {

    @NotNull
    @Valid
    private PatientIdReferenceInput patient;

    @NotNull
    private OffsetDateTime startTime;

    private OffsetDateTime endTime;

    @NotNull
    @Valid
    private ExamReferenceInput exam;

    @NotNull
    @Valid
    private WorkerIdReferenceInput worker;

    private HealthInsuranceIdReferenceInput healthInsurance;

//    Remover do DB PatientHistoric

}
