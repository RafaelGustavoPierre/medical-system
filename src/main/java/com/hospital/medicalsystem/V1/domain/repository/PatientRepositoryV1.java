package com.hospital.medicalsystem.V1.domain.repository;

import com.hospital.medicalsystem.V1.domain.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepositoryV1 extends JpaRepository<Patient, Long> {

    @Query("FROM Patient p WHERE p.id = :id")
    Patient findByPatientId(@Param("id") Long id);


}
