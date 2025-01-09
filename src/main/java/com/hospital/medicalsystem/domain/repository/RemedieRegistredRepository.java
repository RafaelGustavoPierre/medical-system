package com.hospital.medicalsystem.domain.repository;

import com.hospital.medicalsystem.domain.model.RemedieRegistred;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RemedieRegistredRepository extends JpaRepository<RemedieRegistred, Long> {

    @Query("FROM RemedieRegistred rr WHERE rr.patientHistoric.id = :id")
    List<RemedieRegistred> findByPatientHistoricId(Long id);

}
