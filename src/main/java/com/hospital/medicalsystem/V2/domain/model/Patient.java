package com.hospital.medicalsystem.V2.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Patient {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String cpf;

    private String gender;

    private OffsetDateTime registrationDate;

    private OffsetDateTime dateOfBirth;

    private String father;

    private String mother;

    private String nationality;

    private String cellPhone;

    private String phone;

    private String addressStreet;

    private String addressNumber;

    private String addressNeighborhood;

    private String addressCity;

    private String addressState;

    private String addressComplement;

    private String observation;

}
