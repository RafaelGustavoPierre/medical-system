package com.hospital.medicalsystem.domain.service;

import com.hospital.medicalsystem.domain.model.ExamRegistred;
import com.hospital.medicalsystem.domain.repository.ExamRegistredRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExamRegistredService {

    private final ExamRegistredRepository examRegistredRepository;

    public ExamRegistred findActiveExam(Long patientId) {
        return examRegistredRepository.findActiveExamByPatientId(patientId);
    }

}
