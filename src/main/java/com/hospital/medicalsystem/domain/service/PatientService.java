package com.hospital.medicalsystem.domain.service;

import com.hospital.medicalsystem.domain.exception.EntityNotFoundException;
import com.hospital.medicalsystem.domain.model.Patient;
import com.hospital.medicalsystem.domain.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;

    public Patient findByPatientId(String id) {
        Patient patient = patientRepository.findByPatientId(id);
        if (patient == null) {
            throw new EntityNotFoundException(String.format("Paciente de ID %s não foi encontrado!", id));
        }

        return patient;
    }

}
