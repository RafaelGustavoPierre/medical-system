package com.hospital.medicalsystem.api.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@Setter
public class ExamRegistredModel {

    private Long id;
    private BigDecimal price;
    private OffsetDateTime timeRegistred;
    private ExamModel exam;

}
