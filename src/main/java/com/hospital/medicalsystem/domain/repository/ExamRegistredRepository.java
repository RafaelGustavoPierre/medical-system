package com.hospital.medicalsystem.domain.repository;

import com.hospital.medicalsystem.domain.model.ExamRegistred;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExamRegistredRepository extends JpaRepository<ExamRegistred, Long> {

    @Query("FROM ExamRegistred er WHERE er.patient.id = :id ORDER BY er.id DESC")
    List<ExamRegistred> findByPatientId(@Param("id") Long id);

    @Query("FROM ExamRegistred er WHERE er.patient.id = :id AND er.endTime IS NULL")
    ExamRegistred findActiveExamByPatientId(@Param("id") Long id);

    @Query("FROM ExamRegistred er WHERE er.patient.id = :id ORDER BY er.id DESC LIMIT 1")
    ExamRegistred findLastExamByPatientId(@Param("id") Long id);

}
