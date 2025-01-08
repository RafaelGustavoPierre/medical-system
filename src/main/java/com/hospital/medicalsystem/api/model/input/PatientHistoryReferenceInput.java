package com.hospital.medicalsystem.api.model.input;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatientHistoryReferenceInput {

    @NotNull
    private Long id;

}
