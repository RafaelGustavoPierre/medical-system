package com.hospital.medicalsystem.api.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@Setter
public class RemedieRegistredModel {

    private Long id;
    private Long quantity;
    private BigDecimal price;
    private OffsetDateTime timeRegistred;
    private RemedieModel remedie;

}
