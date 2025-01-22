package com.hospital.medicalsystem.domain.repository;

import com.hospital.medicalsystem.domain.model.PatientHistoric;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientHistoricRepository extends JpaRepository<PatientHistoric, Long> {

    @Query("FROM PatientHistoric ph WHERE ph.patient.id = :id ORDER BY ph.id DESC")
    List<PatientHistoric> findListByPatientId(Long id);

    @Query("FROM PatientHistoric ph WHERE ph.patient.id = :id AND ph.status = 'HOSPITALIZED'")
    PatientHistoric findHospitalizedByPatientId(@Param("id") Long patientId);

    @Query("SELECT COUNT(ph) > 0 FROM PatientHistoric ph WHERE ph.patient.id = :id AND ph.status = 'HOSPITALIZED'")
    boolean existsActiveAdmissionByPatientId(@Param("id") Long patientId);

    @Query("SELECT COUNT(ph) > 0 FROM PatientHistoric ph WHERE ph.patient.id = :id and ph.status = 'HOSPITALIZED'")
    boolean existsHospitalizedByPatientId(@Param("id") Long patientId);

}
