package com.hospital.medicalsystem.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ExamRegistredModel {

    private Long id;
    private BigDecimal price;

    @JsonProperty("startTime")
    private String startTimeString;

    @JsonProperty("endTime")
    private String endTimeString;

    private ExamModel exam;
    private WorkerModel worker;
}
