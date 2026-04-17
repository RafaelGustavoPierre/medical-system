package com.hospital.medicalsystem.V2.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString
public class HealthInsurance {

    @Id
    private Long id;

    @NotBlank
    private String name;

}
