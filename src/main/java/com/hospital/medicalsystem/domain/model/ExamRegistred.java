package com.hospital.medicalsystem.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ExamRegistred {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private BigDecimal price;

    @NotNull
    private OffsetDateTime startTime;

    private OffsetDateTime endTime;

    @Valid
    @ManyToOne
    private Exam exam;

    @Valid
    @ManyToOne
    private Worker worker;

    @JsonIgnore
    @ManyToOne
    private PatientHistory patientHistory;

    public String getStartTimeString() {
        if (startTime != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            return startTime.format(formatter);
        }
        return "";
    }

    public String getEndTimeString() {
        if (endTime != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            return endTime.format(formatter);
        }
        return "";
    }

}
