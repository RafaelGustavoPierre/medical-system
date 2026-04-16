package com.hospital.medicalsystem.V2.api.model.input.reference;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OccupationIdReferenceInput {

    @NotNull
    private Long id;

    @NotNull
    private DepartmentIdReferenceInput department;

}
