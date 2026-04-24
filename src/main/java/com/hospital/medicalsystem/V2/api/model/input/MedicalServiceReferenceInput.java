package com.hospital.medicalsystem.V2.api.model.input;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class MedicalServiceReferenceInput {

    @NotNull
    private Long id;

    @NotNull
    private BigDecimal price;

}
