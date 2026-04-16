package com.hospital.medicalsystem.V2.domain.service;

import com.hospital.medicalsystem.V2.domain.exception.EntityNotFoundException;
import com.hospital.medicalsystem.V2.domain.model.Exam;
import com.hospital.medicalsystem.V2.domain.repository.ExamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExamService {

    private final ExamRepository examRepository;

    public Exam findExamById(Long id) {
        return examRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(String.format("Exame de ID: %s não foi encontrado", id)));
    }


}
