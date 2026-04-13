package com.hospital.medicalsystem.V2.domain.service;

import com.hospital.medicalsystem.V2.domain.model.Patient;
import com.hospital.medicalsystem.V2.domain.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;

    public Patient findPatientByCpf(String cpf) {
        return this.patientRepository.findPatientByCpf(cpf);
    }

}
