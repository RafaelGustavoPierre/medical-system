package com.hospital.medicalsystem.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class RemedieRegistredModel {

    private Long id;
    private Long quantity;
    private BigDecimal price;

    @JsonProperty("timeRegistred")
    private String timeRegistredString;

    private RemedieModel remedie;

}
