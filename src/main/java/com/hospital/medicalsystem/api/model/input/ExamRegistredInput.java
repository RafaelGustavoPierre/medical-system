package com.hospital.medicalsystem.api.model.input;

import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@Setter
public class ExamRegistredInput {

    @NotNull
    @PositiveOrZero
    private BigDecimal price;

    private OffsetDateTime startTime;
    private OffsetDateTime endTime;

    @Valid
    @NotNull
    private ExamReferenceInput exam;

    @Valid
    @NotNull
    private PatientReferenceInput patient;

    @Valid
    @NotNull
    private WorkerReferenceInput worker;

    private PatientHistoricReferenceInput patientHistory;

}
