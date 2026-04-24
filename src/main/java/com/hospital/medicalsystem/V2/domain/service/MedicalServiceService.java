package com.hospital.medicalsystem.V2.domain.service;

import com.hospital.medicalsystem.V2.domain.exception.EntityNotFoundException;
import com.hospital.medicalsystem.V2.domain.model.MedicalService;
import com.hospital.medicalsystem.V2.domain.repository.MedicalServiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MedicalServiceService {

    private final MedicalServiceRepository medicalServiceRepository;

    public MedicalService findExamById(Long id) {
        return medicalServiceRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(String.format("Exame de ID: %s não foi encontrado", id)));
    }


}
