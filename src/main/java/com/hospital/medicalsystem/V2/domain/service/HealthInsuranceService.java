package com.hospital.medicalsystem.V2.domain.service;

import com.hospital.medicalsystem.V2.api.model.input.MedicalServiceRegistredReferenceInput;
import com.hospital.medicalsystem.V2.domain.exception.EntityNotFoundException;
import com.hospital.medicalsystem.V2.domain.model.HealthInsurance;
import com.hospital.medicalsystem.V2.domain.model.HealthInsurancePatient;
import com.hospital.medicalsystem.V2.domain.model.Patient;
import com.hospital.medicalsystem.V2.domain.repository.HealthInsuranceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HealthInsuranceService {

    private final HealthInsuranceRepository healthInsuranceRepository;
    private final HealthInsurancePatientService healthInsurancePatientService;

    public HealthInsurance findHealthInsuranceById(Long id) {
        return healthInsuranceRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(String.format("Convênio de ID: %s não foi encontrado.", id)));
    }

    public HealthInsurance resolveHealthInsurance(Patient patient, MedicalServiceRegistredReferenceInput scheduleExam) {
        Long healthInsuranceId = scheduleExam.getHealthInsurance().getId();

        HealthInsurancePatient link = healthInsurancePatientService.findByPatientIdAndHealthInsuranceId(patient.getId(),
                healthInsuranceId);

        return link != null ? link.getHealthInsurance() : this.findHealthInsuranceById(1L);
    }

}
