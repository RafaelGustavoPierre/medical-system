package com.hospital.medicalsystem.api.model.input;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatientHistoricReferenceInput {

    @NotNull
    private Long id;

}
