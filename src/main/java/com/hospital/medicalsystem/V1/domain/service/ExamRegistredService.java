package com.hospital.medicalsystem.V1.domain.service;

import com.hospital.medicalsystem.V1.domain.exception.EntityNotFoundExceptionV1;
import com.hospital.medicalsystem.V1.domain.model.ExamRegistred;
import com.hospital.medicalsystem.V1.domain.repository.ExamRegistredRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExamRegistredService {

    private final static String ACTIVE_EXAM_NOT_FOUND = "No active exam found";

    private final ExamRegistredRepository examRegistredRepository;

    public ExamRegistred findActiveExam(Long patientHistoryId, Long examId) {
        var activeExam  = examRegistredRepository.findExamRegistredByPatientId(patientHistoryId, examId);
        if (activeExam == null) {
            throw new EntityNotFoundExceptionV1(ACTIVE_EXAM_NOT_FOUND);
        }

        return activeExam;
    }

    public boolean existsActiveExamByPatientAndExamId(Long patientId, Long examId) {
        return examRegistredRepository.existsActiveExamByPatientAndExamId(patientId, examId);
    }

}
