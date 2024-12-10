package com.hospital.medicalsystem.domain.repository;

import com.hospital.medicalsystem.domain.model.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamRepository extends JpaRepository<Exam, Long> {
}
