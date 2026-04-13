package com.hospital.medicalsystem.V2.domain.repository;

import com.hospital.medicalsystem.V2.domain.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    @Query("FROM Patient p WHERE p.cpf = :cpf")
    Patient findPatientByCpf(@Param("cpf") String cpf);

}
