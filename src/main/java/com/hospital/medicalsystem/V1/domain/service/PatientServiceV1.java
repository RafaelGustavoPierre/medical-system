package com.hospital.medicalsystem.V1.domain.service;

import com.hospital.medicalsystem.V1.domain.exception.EntityNotFoundException;
import com.hospital.medicalsystem.V1.domain.model.Patient;
import com.hospital.medicalsystem.V1.domain.repository.PatientRepositoryV1;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientServiceV1 {

    private final PatientRepositoryV1 patientRepositoryV1;

    public Patient findByPatientId(Long id) {
        Patient patient = patientRepositoryV1.findByPatientId(id);
        if (patient == null) {
            throw new EntityNotFoundException(String.format("Paciente de ID %s não foi encontrado!", id));
        }

        return patient;
    }

}
