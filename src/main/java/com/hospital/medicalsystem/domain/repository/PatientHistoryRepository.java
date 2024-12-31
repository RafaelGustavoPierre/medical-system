package com.hospital.medicalsystem.domain.repository;

import com.hospital.medicalsystem.domain.model.PatientHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientHistoryRepository extends JpaRepository<PatientHistory, Long> {

    @Query("FROM PatientHistory ph WHERE ph.patient.id = :id ORDER BY ph.id DESC")
    List<PatientHistory> findByPatientId(Long id);

}
