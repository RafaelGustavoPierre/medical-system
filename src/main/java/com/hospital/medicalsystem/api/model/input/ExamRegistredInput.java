package com.hospital.medicalsystem.api.model.input;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@Setter
public class ExamRegistredInput {

    @NotNull
    private BigDecimal price;

    @NotNull
    private OffsetDateTime startTime;

    private OffsetDateTime endTime;

    @NotNull
    private ExamReferenceInput exam;

    @NotNull
    private PatientReferenceInput patient;

}
