package com.hospital.medicalsystem.V2.domain.service;

import com.hospital.medicalsystem.V2.domain.model.HealthInsurancePatient;
import com.hospital.medicalsystem.V2.domain.repository.HealthInsurancePatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HealthInsurancePatientService {

    private final HealthInsurancePatientRepository healthInsurancePatientRepository;

    public HealthInsurancePatient findByPatientIdAndHealthInsuranceId(Long patientId, Long healthInsuranceId) {
        return healthInsurancePatientRepository.findByPatientIdAndHealthInsuranceId(patientId, healthInsuranceId);
    }

    public List<HealthInsurancePatient> findPatientListHealthInsurance(Long patientId) {
        return healthInsurancePatientRepository.findPatientListHealthInsurance(patientId);
    }

}
