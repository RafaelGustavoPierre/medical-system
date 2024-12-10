package com.hospital.medicalsystem.domain.service;

import com.hospital.medicalsystem.domain.exception.EntityNotFoundException;
import com.hospital.medicalsystem.domain.model.Exam;
import com.hospital.medicalsystem.domain.repository.ExamRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExamService {

    private final static String EXAM_NOT_FOUND = "Exam ID %s NOT FOUND";

    private final ExamRepository examRepository;

    public Exam findByExamId(Long examId) {
        return examRepository.findById(examId).orElseThrow(() ->
                new EntityNotFoundException(String.format(EXAM_NOT_FOUND, examId)));
    }

}
