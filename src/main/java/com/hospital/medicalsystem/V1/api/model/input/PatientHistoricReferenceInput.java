package com.hospital.medicalsystem.V1.api.model.input;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatientHistoricReferenceInput {

    @NotNull
    private Long id;

}
