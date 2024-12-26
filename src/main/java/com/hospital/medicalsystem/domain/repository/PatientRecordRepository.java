package com.hospital.medicalsystem.domain.repository;

import com.hospital.medicalsystem.domain.model.PatientRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRecordRepository extends JpaRepository<PatientRecord, Long> {

    @Query("FROM PatientRecord pr WHERE pr.patient.id = :id")
    PatientRecord findByPatientId(@Param("id") Long id);

}
