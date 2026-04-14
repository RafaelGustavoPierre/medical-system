package com.hospital.medicalsystem.V2.domain.service;

import com.hospital.medicalsystem.V2.domain.exception.EntityNotFoundException;
import com.hospital.medicalsystem.V2.domain.model.Patient;
import com.hospital.medicalsystem.V2.domain.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;

    public Patient findPatientByCpf(String cpf) {
        var patient = this.patientRepository.findPatientByCpf(cpf);
        if (patient == null) {
            throw new EntityNotFoundException(String.format("Paciente de CPF: %s não foi encontrado.", cpf));
        }
        return patient;
    }

}
