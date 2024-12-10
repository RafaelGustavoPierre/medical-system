package com.hospital.medicalsystem.domain.repository;

import com.hospital.medicalsystem.domain.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    @Query("FROM Patient p WHERE p.id = :id")
    Patient findByPatientId(@Param("id") Long id);


}
