package com.hospital.medicalsystem.V2.domain.repository;

import com.hospital.medicalsystem.V2.domain.model.HealthInsurancePatient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HealthInsurancePatientRepository extends JpaRepository<HealthInsurancePatient, Long> {

    HealthInsurancePatient findByPatientIdAndHealthInsuranceId(Long patientId, Long healthInsuranceId);

    boolean existsByPatientIdAndHealthInsuranceId(Long patientId, Long healthInsuranceId);

    @Query("FROM HealthInsurancePatient hip WHERE hip.patient.id = :patientId")
    List<HealthInsurancePatient> findPatientListHealthInsurance(@Param("patientId") Long patientId);

}