package com.hospital.medicalsystem.V2.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class HealthInsurancePatient {

    @Id
    private Long id;

    @ManyToOne
    private Patient patient;

    @OneToOne
    private HealthInsurance healthInsurance;

}
