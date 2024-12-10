package com.hospital.medicalsystem.domain.service;

import com.hospital.medicalsystem.api.assembler.PatientExamRegistredDisassembler;
import com.hospital.medicalsystem.api.model.input.ExamRegistredInput;
import com.hospital.medicalsystem.domain.exception.EntityNotFoundException;
import com.hospital.medicalsystem.domain.exception.ActiveExamConflictException;
import com.hospital.medicalsystem.domain.model.Exam;
import com.hospital.medicalsystem.domain.model.ExamRegistred;
import com.hospital.medicalsystem.domain.model.Patient;
import com.hospital.medicalsystem.domain.repository.ExamRegistredRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;

@Service
@RequiredArgsConstructor
public class PatientExamService {

    private final static String ACTIVE_EXAM_NOT_FOUND = "No active exam found";
    private final static String EXAM_ACTIVE_CONFLICT = "Patient %s is taking the %s exam";

    private final PatientService patientService;
    private final ExamService examService;
    private final ExamRegistredService examRegistredService;

    private final ExamRegistredRepository examRegistredRepository;

    private final PatientExamRegistredDisassembler examRegistredDisassembler;

    public ExamRegistred startExam(ExamRegistredInput examRegistredInput) {
        Patient patient = patientService.findByPatientId(examRegistredInput.getPatient().getId());
        ExamRegistred activeExam = examRegistredService.findActiveExam(patient.getId());
        if (activeExam != null) {
            throw new ActiveExamConflictException(
                    String.format(EXAM_ACTIVE_CONFLICT, activeExam.getPatient().getName(), activeExam.getExam().getName()));
        }

        examRegistredInput.setStartTime(OffsetDateTime.now());
        ExamRegistred examRegistredDomain = examRegistredRepository.save(examRegistredDisassembler.toModel(examRegistredInput));

        Exam exam = examService.findByExamId(examRegistredDomain.getExam().getId());

        examRegistredDomain.setPatient(patient);
        examRegistredDomain.setExam(exam);

        return examRegistredDomain;
    }

    public ExamRegistred finishExam(Long patientId) {
        Patient patient = patientService.findByPatientId(patientId);
        ExamRegistred activeExam = examRegistredService.findActiveExam(patient.getId());
        if (activeExam == null) {
            throw new EntityNotFoundException(ACTIVE_EXAM_NOT_FOUND);
        }

        activeExam.setEndTime(OffsetDateTime.now());
        return examRegistredRepository.save(activeExam);
    }

}
