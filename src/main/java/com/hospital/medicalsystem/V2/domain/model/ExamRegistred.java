package com.hospital.medicalsystem.V2.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

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

    @NotNull
    @ManyToOne
    @JoinColumn(name = "exam_id", nullable = false)
    private Exam exam;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "worker_id", nullable = false)
    private Worker worker;

    @ManyToOne
    @JoinColumn(name = "healthInsurance_id", nullable = false)
    private HealthInsurance healthInsurance;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

//    Remover do DB PatientHistoric
}
