package com.hospital.medicalsystem.V2.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WorkerHealthInsurance {

    @EmbeddedId
    private WorkerHealthInsuranceId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("workerId")
    @JoinColumn(name = "worker_id")
    private Worker worker;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("healthInsuranceId")
    @JoinColumn(name = "health_insurance_id")
    private HealthInsurance healthInsurance;

}
