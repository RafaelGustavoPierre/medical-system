package com.hospital.medicalsystem.domain.repository;

import com.hospital.medicalsystem.domain.model.ExamRegistred;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExamRegistredRepository extends JpaRepository<ExamRegistred, Long> {

    @Query("FROM ExamRegistred er WHERE er.patientHistory.id = :id")
    List<ExamRegistred> findByPatientHistoryId(@Param("id") Long id);

}
