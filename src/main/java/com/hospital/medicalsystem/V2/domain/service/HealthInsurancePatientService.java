package com.hospital.medicalsystem.V2.domain.service;

import com.hospital.medicalsystem.V2.domain.exception.EntityNotFoundException;
import com.hospital.medicalsystem.V2.domain.model.HealthInsurancePatient;
import com.hospital.medicalsystem.V2.domain.repository.HealthInsurancePatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HealthInsurancePatientService {

    private final HealthInsurancePatientRepository healthInsurancePatientRepository;

    public HealthInsurancePatient findByPatientIdAndHealthInsuranceId(Long patientId, Long healthInsuranceId) {
         var healthInsurancePatient = healthInsurancePatientRepository.findByPatientIdAndHealthInsuranceId(patientId, healthInsuranceId);
         if (healthInsurancePatient == null) {
             throw new EntityNotFoundException("O Paciente não possui este Convênio!");
         }

        return healthInsurancePatient;
    }

}
