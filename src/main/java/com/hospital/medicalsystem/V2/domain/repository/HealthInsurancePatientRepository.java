package com.hospital.medicalsystem.V2.domain.repository;

import com.hospital.medicalsystem.V2.domain.model.HealthInsurancePatient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HealthInsurancePatientRepository extends JpaRepository<HealthInsurancePatient, Long> {

    HealthInsurancePatient findByPatientIdAndHealthInsuranceId(Long patientId, Long healthInsuranceId);

    boolean existsByPatientIdAndHealthInsuranceId(Long patientId, Long healthInsuranceId);

}