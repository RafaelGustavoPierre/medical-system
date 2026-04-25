package com.hospital.medicalsystem.V2.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class WorkerHealthInsuranceId implements Serializable {

    @Column(name = "worker_id")
    private Long workerId;

    @Column(name = "health_insurance_id")
    private Long healthInsuranceId;

}
