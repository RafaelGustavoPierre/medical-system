package com.hospital.medicalsystem.V2.api.model;

import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
public class PatientResumeModel {

    private Long id;
    private String name;
    private OffsetDateTime dateOfBirth;
    private String cpf;
    private String phone;
    private String cell_phone;
    private String gender;
    private String email;

}
