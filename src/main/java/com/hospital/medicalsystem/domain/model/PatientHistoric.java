package com.hospital.medicalsystem.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class PatientHistoric {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private OffsetDateTime dateAdmission;

    private OffsetDateTime dateDischarge;

    @NotBlank
    private String status;

    @JsonIgnore
    @OneToOne
    private Patient patient;

    @OneToOne
    private Worker worker;

    public String getDateAdmissionString() {
        if (dateAdmission != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            return dateAdmission.format(formatter);
        }
        return "";
    }

    public String getDateDischargeString() {
        if (dateDischarge != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            return dateDischarge.format(formatter);
        }
        return "";
    }
}
