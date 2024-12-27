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
public class RemedieRegistred {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Long quantity;

    @NotNull
    private BigDecimal price;

    @NotNull
    private OffsetDateTime timeRegistred;

    @Valid
    @NotNull
    @ManyToOne
    private Remedie remedie;

    @JsonIgnore
    @ManyToOne
    private Patient patient;

    public String getTimeRegistredString() {
        if (timeRegistred != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            return timeRegistred.format(formatter);
        }
        return "";
    }

}
