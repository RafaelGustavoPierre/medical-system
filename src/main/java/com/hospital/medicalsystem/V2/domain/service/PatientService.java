package com.hospital.medicalsystem.V2.domain.service;

import com.hospital.medicalsystem.V2.domain.exception.EntityNotFoundException;
import com.hospital.medicalsystem.V2.domain.model.Patient;
import com.hospital.medicalsystem.V2.domain.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientService {

    public static final String PATIENT_CPF_NOT_FOUND = "Paciente de CPF: %s não foi encontrado.";

    private final PatientRepository patientRepository;

    public Patient findPatientByCpf(String cpf) {
        var patient = this.patientRepository.findPatientByCpf(cpf);
        if (patient == null) {
            throw new EntityNotFoundException(String.format(PATIENT_CPF_NOT_FOUND, cpf));
        }
        return patient;
    }

}
