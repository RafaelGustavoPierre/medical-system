package com.hospital.medicalsystem.domain.repository;

import com.hospital.medicalsystem.domain.model.ExamRegistred;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExamRegistredRepository extends JpaRepository<ExamRegistred, Long> {

    @Query("FROM ExamRegistred er WHERE er.patientHistoric.id = :patientHistoricId")
    List<ExamRegistred> findByPatientHistoricId(@Param("patientHistoricId") Long patientHistoricId);

    @Query("SELECT COUNT(er) > 0 FROM ExamRegistred er WHERE er.patientHistoric.id = :patientHistoricId AND er.exam.id = :examId AND er.endTime IS NULL")
    boolean existsActiveExamByPatientAndExamId(@Param("patientHistoricId") Long patientHistoricId, @Param("examId") Long examId);

    @Query("FROM ExamRegistred er WHERE er.patientHistoric.id = :patientHistoricId AND er.exam.id = :examId AND er.endTime IS NULL")
    ExamRegistred findExamRegistredByPatientId(@Param("patientHistoricId") Long patientHistoricId, @Param("examId") Long examId);

    @Query("FROM ExamRegistred er WHERE er.patientHistoric.id = :patientHistoricId AND er.endTime IS NULL")
    List<ExamRegistred> findActiveExamListByPatientId(@Param("patientHistoricId") Long patientHistoricId);

    @Query("SELECT COUNT(er) > 0 FROM ExamRegistred er WHERE er.patientHistoric.id = :patientHistoricId AND er.endTime IS NULL")
    boolean existsActiveExamByPatient(@Param("patientHistoricId") Long patientHistoricId);
}
