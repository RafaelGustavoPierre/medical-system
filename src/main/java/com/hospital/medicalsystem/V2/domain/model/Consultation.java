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
public class Consultation {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "healthInsurance_id")
    private HealthInsurance healthInsurance;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "worker_id")
    private Worker worker;

    private OffsetDateTime dateRegistration;

    @NotNull
    private BigDecimal price;

    private String observation;

}
