package com.hospital.medicalsystem.domain.service;

import com.hospital.medicalsystem.domain.model.ExamRegistred;
import com.hospital.medicalsystem.domain.model.Patient;
import com.hospital.medicalsystem.domain.repository.ExamRegistredRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;

@Service
@RequiredArgsConstructor
public class PatientExamService {

    private final PatientService patientService;
    private final ExamRegistredService examRegistredService;

    private final ExamRegistredRepository examRegistredRepository;

    public ExamRegistred finishExam(String patientId) {
        Patient patient = patientService.findByPatientId(patientId);

        ExamRegistred activeExams = examRegistredService.findActiveExam(patient.getId());
        activeExams.setEndTime(OffsetDateTime.now());

        return examRegistredRepository.save(activeExams);
    }

}
