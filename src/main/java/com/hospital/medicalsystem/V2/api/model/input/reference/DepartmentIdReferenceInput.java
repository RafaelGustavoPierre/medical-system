package com.hospital.medicalsystem.V2.api.model.input.reference;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DepartmentIdReferenceInput {

    @NotNull
    private Long id;

}
